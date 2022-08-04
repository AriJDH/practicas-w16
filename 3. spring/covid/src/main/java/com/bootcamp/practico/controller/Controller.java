package com.bootcamp.practico.controller;

import com.bootcamp.practico.dto.RiskPersonDto;
import com.bootcamp.practico.dto.SymptomDto;
import com.bootcamp.practico.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private HealthService service;


    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> findSymptom() {
        return new ResponseEntity<>(service.findSymptom(), HttpStatus.OK);

    }


    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findSymptomByName(@PathVariable String name) {

        SymptomDto symptomDto = service.findSymptomByName(SymptomDto.builder().name(name).build());
        return symptomDto != null ? new ResponseEntity<>(symptomDto, HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDto>> findRiskPerson() {
        return new ResponseEntity<>(service.findRiskPerson(), HttpStatus.OK);

    }
}
