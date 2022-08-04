package com.tomas.personajestarwars.controller;

import com.tomas.personajestarwars.dto.PersonajeDto;
import com.tomas.personajestarwars.service.PersonajeService;
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
    PersonajeService personajeService;

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDto>> obtenerPersonaje(@PathVariable String nombre){

        return new ResponseEntity<>(personajeService.listarPersonaje(nombre), HttpStatus.OK);

    }

}
