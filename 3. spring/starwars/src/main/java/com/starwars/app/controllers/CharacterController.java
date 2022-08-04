package com.starwars.app.controllers;

import com.starwars.app.dto.CharacterDTO;
import com.starwars.app.service.CharacterService;
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
    private CharacterService characterService;

    @GetMapping("/find/{name}")
    private ResponseEntity<List<CharacterDTO>> findCharacter(@PathVariable String name){
        return new ResponseEntity<>(characterService.find(name), HttpStatus.OK);
    }

}
