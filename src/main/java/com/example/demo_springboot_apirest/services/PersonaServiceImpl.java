package com.example.demo_springboot_apirest.services;

import com.example.demo_springboot_apirest.entities.Persona;
import com.example.demo_springboot_apirest.repositories.BaseRepository;
import com.example.demo_springboot_apirest.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
        this.personaRepository = personaRepository;
    }
}
