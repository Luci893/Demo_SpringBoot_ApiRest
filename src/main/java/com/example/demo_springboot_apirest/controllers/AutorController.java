package com.example.demo_springboot_apirest.controllers;

import com.example.demo_springboot_apirest.entities.Autor;
import com.example.demo_springboot_apirest.services.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Permite el acceso a la API desde distintos origenes o clientes
@RequestMapping(path= "/api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl>{
}
