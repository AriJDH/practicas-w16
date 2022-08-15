package com.bootcamp.morse.controller;

import com.bootcamp.morse.dto.MorseDto;
import com.bootcamp.morse.repository.IMorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @Autowired
    IMorseRepository iMorseRepository;

    @GetMapping("/{message}")
    public ResponseEntity<MorseDto> getMorse(@PathVariable String message){
        return new ResponseEntity<>(iMorseRepository.contrucMorse(message), HttpStatus.OK);
    }
}
