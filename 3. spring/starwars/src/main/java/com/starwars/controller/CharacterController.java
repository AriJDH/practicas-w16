package com.starwars.controller;

import com.starwars.dto.CharacterDTO;
import com.starwars.entity.Character;
import com.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    //@decorator \n metodo;
    @Autowired //singleton!
    private CharacterService characterService;
    @GetMapping("/character")
    public ResponseEntity<List<CharacterDTO>> getCharacters() {
        return new ResponseEntity<>(this.characterService.getCharacters(), HttpStatus.OK);
    }

    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDTO>> searchByName(@PathVariable String name) {
        return new ResponseEntity<>(this.characterService.searchByName(name), HttpStatus.OK);
    }

    @PostMapping("/character") //ahora vemos como agregar
    public ResponseEntity addCharacters(@RequestBody List<Character> characters) {
        this.characterService.addCharacters(characters);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
