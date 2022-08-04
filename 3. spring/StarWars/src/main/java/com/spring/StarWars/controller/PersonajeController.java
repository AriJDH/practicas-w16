package com.spring.StarWars.controller;

import com.spring.StarWars.dto.PersonajeDTO;
import com.spring.StarWars.service.PersonajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonajeController {

    PersonajeService personajeService = new PersonajeService();

    @GetMapping("/findCharacter/{name}")

    public ResponseEntity<List<PersonajeDTO>> searchPersonaje (@PathVariable String name){
        return new ResponseEntity<>(personajeService.searchPersonaje(name),HttpStatus.OK);
    }


}
