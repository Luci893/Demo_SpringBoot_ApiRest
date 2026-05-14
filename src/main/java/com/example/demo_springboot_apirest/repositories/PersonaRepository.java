package com.example.demo_springboot_apirest.repositories;

/* Esta interface es un DAO, que vendría siendo un patrón que separa por completo la lógica del negocio
de la aplicación, de la lógica para acceder a la Base de datos. Este PersonaRepository se comunica
directamente con la BD. */

import com.example.demo_springboot_apirest.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//JpaRepository<Nombre clase, Tipo de Valor del ID de esa clase>
public interface PersonaRepository extends BaseRepository<Persona, Long> {

}
