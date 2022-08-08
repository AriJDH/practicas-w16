package com.bootcamp.starwars.controllers;

import com.bootcamp.starwars.dtos.PersonajeDTO;
import com.bootcamp.starwars.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    PersonajeService personajeService;

    @GetMapping("/searchCharacter/{name}")
    public ResponseEntity<List<PersonajeDTO>> searchCharacter(@PathVariable String name){
        return new ResponseEntity<List<PersonajeDTO>>(personajeService.searchCharacter(name), HttpStatus.OK);
    }
}
