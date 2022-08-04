package com.spring.personajes_star_wars.controller;

import com.spring.personajes_star_wars.DTO.PersonajeDTO;
import com.spring.personajes_star_wars.service.IPersonajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajesController {

    @Autowired
    IPersonajesService iPersonajesService;

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> lstarPersonajesxNombre(@PathVariable String name){
        return new ResponseEntity<>(iPersonajesService.listarPersonajesxNombre(name), HttpStatus.OK);
    }

}
