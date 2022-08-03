package com.bootcamp.covid.controllers;

import com.bootcamp.covid.dtos.RiskPersonDTO;
import com.bootcamp.covid.dtos.SymptomDTO;
import com.bootcamp.covid.services.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    private final CovidService service;

    public CovidController(CovidService service) {
        this.service = service;
    }

    @GetMapping("/symptoms")
    public ResponseEntity<List<SymptomDTO>> getSymptoms() {
        return new ResponseEntity<>(service.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/symptoms/{name}")
    public ResponseEntity<SymptomDTO> getSymptom(@PathVariable String name) {
        return new ResponseEntity<>(service.getSymptom(name), HttpStatus.OK);
    }

    @GetMapping("/riskPeople")
    public ResponseEntity<List<RiskPersonDTO>> getRiskPeople() {
        return new ResponseEntity<>(service.getRiskPeople(), HttpStatus.OK);
    }
}
