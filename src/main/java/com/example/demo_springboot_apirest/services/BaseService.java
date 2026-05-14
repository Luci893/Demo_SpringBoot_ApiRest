package com.example.demo_springboot_apirest.services;

// Interface genérica que declarará todos los métodos necesarios para el CRUD

import com.example.demo_springboot_apirest.entities.Base;

import java.io.Serializable;
import java.util.List;

/* <E> : hace referencia a la entidad, se coloca así para que puedan acceder
todas las clases de Servicios a estos métodos. Reemplazando E por la entidad
que se manda en <> */
public interface BaseService <E extends Base, ID extends Serializable> {

    // Trae una lista de todos los elementos
    public List<E> findAll() throws Exception;

    // Trae un elemento en base a su id
    public E findById(ID id) throws Exception;

    // Guarda un elemento
    public E save(E entity) throws Exception;

    // Actualizar un elemento
    public E update(ID id, E entity)  throws Exception;

    // Elimina un elemento de la BD
    public boolean delete(ID id) throws Exception;

}
