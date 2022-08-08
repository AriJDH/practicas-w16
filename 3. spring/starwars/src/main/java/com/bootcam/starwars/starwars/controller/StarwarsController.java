package com.bootcam.starwars.starwars.controller;

import com.bootcam.starwars.starwars.dto.PersonajeDto;
import com.bootcam.starwars.starwars.service.StarWarsSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarwarsController {
    @Autowired
    private StarWarsSvc characterService;


    @GetMapping("/find/{name}")
    private ResponseEntity<List<PersonajeDto>> findCharacter(@PathVariable String name){
        return new ResponseEntity<>(characterService.findCharacter(name), HttpStatus.OK);
    }
}
