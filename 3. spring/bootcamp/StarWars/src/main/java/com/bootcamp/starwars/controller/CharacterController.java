package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.CharacterDto;
import com.bootcamp.starwars.entity.Character;
import com.bootcamp.starwars.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("starWars")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/findCharacters/{name}")
    public ResponseEntity<List<CharacterDto>> getAllCharacters(@PathVariable String name){
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }
}
