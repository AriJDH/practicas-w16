package com.starwars.starwars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.starwars.service.CharacterService;
import com.starwars.starwars.dto.PersonajeDTO;

@RestController
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping("/characters/search")
    public ResponseEntity<List<PersonajeDTO>> findAllByNameContains(@RequestParam String name) {
        return ResponseEntity.ok(characterService.findAllByNameContains(name));
    }
}
