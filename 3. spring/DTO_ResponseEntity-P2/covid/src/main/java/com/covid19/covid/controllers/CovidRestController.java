package com.covid19.covid.controllers;


import com.covid19.covid.DTO.PersonDTO;
import com.covid19.covid.DTO.SymptomDTO;
import com.covid19.covid.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidRestController {

    @Autowired
    private CovidService service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> listSymptom(){
        return new ResponseEntity<>(service.listSymptom(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> consultSymptom(@PathVariable String name){
        return new ResponseEntity<>(service.consultSymptom(name), HttpStatus.OK);
    }
    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonDTO>> listPersonatRisk(){
        return new ResponseEntity<>(service.listPersonAtRisk(), HttpStatus.OK);
    }
}
