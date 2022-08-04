package com.example.starwars.controller;

import com.example.starwars.dto.CharacterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.starwars.service.FindService;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class CharacterController {

    @Autowired
    private FindService service;

    @GetMapping("/findCharacter/{name}")
    public ResponseEntity<List<CharacterDto>> findCharacters(@PathVariable String name) {
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);

    }

}
