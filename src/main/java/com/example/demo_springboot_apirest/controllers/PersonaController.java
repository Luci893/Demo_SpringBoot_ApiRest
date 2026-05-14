package com.example.demo_springboot_apirest.controllers;

import com.example.demo_springboot_apirest.entities.Persona;
import com.example.demo_springboot_apirest.services.PersonaService;
import com.example.demo_springboot_apirest.services.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Permite el acceso a la API desde distintos origenes o clientes
@RequestMapping(path= "/api/v1/personas") //A través de esta url podemos acceder a los métodos de persona
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage() +"\"}");
        }
    }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+ e.getMessage() +"\"}");
        }
    }
}
