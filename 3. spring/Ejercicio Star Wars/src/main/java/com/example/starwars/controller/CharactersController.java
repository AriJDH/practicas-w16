package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.CharactersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharactersController {

    CharactersService service = new CharactersService();

    @GetMapping("/characters/{name}")
    public ResponseEntity<List<CharacterDTO>> getCharacters(@PathVariable String name){
        return new ResponseEntity<>(service.getCharacters(name), HttpStatus.OK);
    }
}
