package com.practice.starWars.controller;

import com.practice.starWars.dto.CharacterStarWarsDTO;
import com.practice.starWars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerCharacter {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/find/{name}")
    private ResponseEntity<List<CharacterStarWarsDTO>> findCharacterByName(@PathVariable String name){
        List<CharacterStarWarsDTO> listResult = characterService.foundCharacterByName(name);

        return new ResponseEntity<>(listResult, HttpStatus.OK);
    }
}
