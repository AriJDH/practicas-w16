package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.PersonDto;
import com.bootcamp.covid19.dto.SymptomDto;
import com.bootcamp.covid19.service.Covid19Service;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("covid")
public class Covid19Controller {

    Covid19Service service = new Covid19Service();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> getAllSymptoms(){
        return new ResponseEntity<>(service.getAllSymptoms(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> getSymptomByName(@PathVariable String name){
        return new ResponseEntity<>(service.getSymptomByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonDto>> getPersonsWithRisk(){
        return new ResponseEntity<>(service.getPersonsWithRisk(), HttpStatus.OK);
    }
}
