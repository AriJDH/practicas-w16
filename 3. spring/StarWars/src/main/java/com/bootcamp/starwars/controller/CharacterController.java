package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.response.CharacterDTO;
import com.bootcamp.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @Autowired
    CharacterService service;
    @GetMapping("/{name}")
    public ResponseEntity<List<CharacterDTO>> findCharacterByName(@PathVariable String name){
        return new ResponseEntity<>(service.findCharacterByName(name), HttpStatus.OK);
    }
}
