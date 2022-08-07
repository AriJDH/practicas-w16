package com.example.ejercicioproyectostarwars.controller;

import com.example.ejercicioproyectostarwars.dto.PersonajeDto;
import com.example.ejercicioproyectostarwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeRestController {

    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/{filter}")
    public List<PersonajeDto> obtenerPersonajeFiltrado(@PathVariable String filter){
        return personajeService.findLisWithWord(filter);
    }


}
