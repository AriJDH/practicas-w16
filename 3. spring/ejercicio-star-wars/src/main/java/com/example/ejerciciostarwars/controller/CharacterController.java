package com.example.ejerciciostarwars.controller;

import com.example.ejerciciostarwars.dto.CharacterDTO;
import com.example.ejerciciostarwars.entity.Character;
import com.example.ejerciciostarwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<?> insertCharacters(@RequestBody List<Character> characters){
        characterService.saveCharacters(characters);
        return ResponseEntity.status(HttpStatus.OK).body("Persistidos");
    }

    @GetMapping
    public ResponseEntity<List<CharacterDTO>> charactersNamedLike(@RequestParam String name) {
        return ResponseEntity.ok(characterService.charactersNamedLike(name));
    }

}
