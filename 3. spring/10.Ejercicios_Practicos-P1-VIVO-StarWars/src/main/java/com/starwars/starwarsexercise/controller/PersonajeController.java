package com.starwars.starwarsexercise.controller;

import com.starwars.starwarsexercise.dto.PersonajeDto;
import com.starwars.starwarsexercise.service.PersonajeService;
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
    PersonajeService service;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDto>> findPersonajeByName(@PathVariable String name){
        return new ResponseEntity<>(service.findPersonajesByName(name), HttpStatus.OK);
    }
}
