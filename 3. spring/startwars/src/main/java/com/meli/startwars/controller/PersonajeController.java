package com.meli.startwars.controller;
import com.meli.startwars.dto.PersonajeDTO;
import com.meli.startwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class PersonajeController {

    @Autowired
    PersonajeService personajeservice;

    @GetMapping("/{nombre}")

    public ResponseEntity<List <PersonajeDTO>> find(@PathVariable String nombre){

        return new ResponseEntity<>(personajeservice.mostrarPersonaje(nombre), HttpStatus.OK);

    }
}
