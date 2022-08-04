package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.response.PersonajeDTO;
import com.bootcamp.starwars.service.IPersonajeService;
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
    IPersonajeService iPersonajeService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> findAllPersonajes(@PathVariable String name){
        return new ResponseEntity<>(iPersonajeService.findPersonajeByName(name), HttpStatus.OK);
    }

}
