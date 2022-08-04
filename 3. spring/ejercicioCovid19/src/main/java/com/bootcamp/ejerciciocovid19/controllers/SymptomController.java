package com.bootcamp.ejerciciocovid19.controllers;

import com.bootcamp.ejerciciocovid19.dtos.RiskPersonDTO;
import com.bootcamp.ejerciciocovid19.dtos.SymptomDTO;
import com.bootcamp.ejerciciocovid19.services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {

    @Autowired
    SymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> findSymptom(){
        return new ResponseEntity<>(symptomService.findAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptomName(@PathVariable String name){
        return new ResponseEntity<>(symptomService.findSymptomName(name), HttpStatus.OK);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> findSymptomName(){
        return new ResponseEntity<>(symptomService.findRiskPersons(), HttpStatus.OK);
    }
}
