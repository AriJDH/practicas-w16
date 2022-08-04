package com.example.covid.controller;

import com.example.covid.dto.PersonaDto;
import com.example.covid.dto.SintomaDto;
import com.example.covid.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {

    @Autowired
    SintomaService service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> findSintoma(){
        return new ResponseEntity<>(service.getAllSintomaDto(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDto> findOneSintoma(@PathVariable String name){
        return new ResponseEntity<>(service.findOneSintomaDto(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/personas")
    public ResponseEntity<List<PersonaDto>> findRiskPersonas(){
        return new ResponseEntity<>(service.findRiskPersonas(), HttpStatus.ACCEPTED);
    }
}
