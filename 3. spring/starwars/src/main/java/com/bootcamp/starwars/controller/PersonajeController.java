package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.response.PersonajeDTO;
import com.bootcamp.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @RequestMapping("/personajes")
    public List<PersonajeDTO> getAll(){
        return this.personajeService.getAll();
    }

    @RequestMapping("/personajes/{name}")
    public List<PersonajeDTO> getByName(@PathVariable String name){
        return this.personajeService.getByName(name);
    }
}
