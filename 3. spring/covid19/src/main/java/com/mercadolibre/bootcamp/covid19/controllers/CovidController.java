package com.mercadolibre.bootcamp.covid19.controllers;

import com.mercadolibre.bootcamp.covid19.dtos.PersonDto;
import com.mercadolibre.bootcamp.covid19.dtos.SymptomDto;
import com.mercadolibre.bootcamp.covid19.models.Person;
import com.mercadolibre.bootcamp.covid19.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    final CovidService covidService;

    @Autowired
    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @RequestMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> allSymptoms(){
        return new ResponseEntity<>(covidService.getAllSymptoms(), HttpStatus.OK);
    }
    @RequestMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findSymptom(@PathVariable String name){
        return new ResponseEntity<>(covidService.getSymptomByName(name), HttpStatus.OK);
    }

    @RequestMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDto>> findSymptom(){
        return new ResponseEntity<>(covidService.getRiskPersons(), HttpStatus.OK);
    }
}
