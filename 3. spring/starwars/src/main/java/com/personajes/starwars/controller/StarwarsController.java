package com.personajes.starwars.controller;

import com.personajes.starwars.dto.PersonajeDTO;
import com.personajes.starwars.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StarwarsController {

    @Autowired
    private StarWarsService starWarsService;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> findAll(){
        return new ResponseEntity<>(starWarsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/personajes/{name}")
    public ResponseEntity<List<PersonajeDTO>> findAllByName(@PathVariable String name){
        return new ResponseEntity<>(starWarsService.findByAllByName(name), HttpStatus.OK);
    }

    @PostMapping("/personajes")
    public ResponseEntity createData(@RequestBody List<PersonajeDTO> personajes){
        starWarsService.saveAll(personajes);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
