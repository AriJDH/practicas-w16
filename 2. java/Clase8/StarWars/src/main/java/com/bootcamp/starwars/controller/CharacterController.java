package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDto;
import com.bootcamp.starwars.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {

    private CharacterService characterService = new CharacterService();
    @GetMapping("/character/{name}")
    public ResponseEntity<List<CharacterDto>> findCharacterName(@PathVariable String name){

        return new ResponseEntity<>(characterService.findAllCharacter(name), HttpStatus.ACCEPTED);
    }
    @GetMapping("/character")
    public ResponseEntity<List<CharacterDto>> findAllData(){

        return new ResponseEntity<>(characterService.findAllData(), HttpStatus.ACCEPTED);
    }

}
