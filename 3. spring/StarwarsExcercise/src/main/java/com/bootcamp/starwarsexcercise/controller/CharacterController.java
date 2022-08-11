package com.bootcamp.starwarsexcercise.controller;

import com.bootcamp.starwarsexcercise.dto.CharacterDto;
import com.bootcamp.starwarsexcercise.service.FindService;
import com.bootcamp.starwarsexcercise.service.FindServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
