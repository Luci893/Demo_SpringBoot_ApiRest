package com.example.demo_springboot_apirest.controllers;

import com.example.demo_springboot_apirest.entities.Base;
import com.example.demo_springboot_apirest.services.BaseService;
import com.example.demo_springboot_apirest.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl <E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long>{

    @Autowired
    protected S servicio;

    /* @GetMapping: se utiliza para consultar o recuperar información (listas, un usuario, etc)
       @PostMapping: se utiliza para enviar, guardar o modificar datos en el servidor(guardar un usuario, etc)
       @PutMapping: se utiliza para actualizar elementos existentes(como usuarios, productos, etc)
       @DeleteMapping: permite eliminar elementos específicos (como usuarios, productos, etc)
     */

    @GetMapping("")
    // Trae todas los elementos en formato JSON
    public ResponseEntity<?> getAll() {
        try{
            // Devuelve lista de elementos con un status OK si hay en la BD.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        } catch (Exception e) {
            // Si no hay elementos retorna status No encontrado con un mensaje en formato JSON
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try{
            // Devuelve el elemento con un status OK si está en la BD.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById((Long) id));
        } catch (Exception e) {
            // Si no esta, retorna status No encontrado con un mensaje en formato JSON
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error por favor intente mas tarde.\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try{
            // Guarda elemento y muestra un status OK si se guardo correctamente.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error por favor intente mas tarde.\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity) {
        try{
            // Actualiza un elemento y muestra un status OK si se actualizo correctamente.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update((Long) id,entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error por favor intente mas tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            // Eliminar un elemento.
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete((Long) id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\""+e.getMessage()+"\"}");
        }
    }
}
