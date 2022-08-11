package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.RiskPersonDTO;
import com.bootcamp.covid19.dto.SymptomDTO;
import com.bootcamp.covid19.services.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller {

    @Autowired
    SymptomService symptomService = new SymptomService();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> getSymptomps(){
        return new ResponseEntity<>(symptomService.getSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> getSymptomp(@PathVariable String name){
        return new ResponseEntity<>(symptomService.getSymptom(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiskPersonDTO>> getRiskPersons(){
        return new ResponseEntity<>(symptomService.getRiskPersons(), HttpStatus.OK);
    }
}
