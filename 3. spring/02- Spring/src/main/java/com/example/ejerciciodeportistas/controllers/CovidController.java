package com.example.ejerciciodeportistas.controllers;

import com.example.ejerciciodeportistas.dto.covid.PersonaDto;
import com.example.ejerciciodeportistas.dto.covid.SintomaDto;
import com.example.ejerciciodeportistas.service.CovidSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    @Autowired
    CovidSvc covidSvc = new CovidSvc();

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDto>> getSintomas(){
        return new ResponseEntity<>(covidSvc.getSintoma(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{enfermedad}")
    public ResponseEntity<SintomaDto> getSintomasNombre(@PathVariable String enfermedad){
        SintomaDto sintoma = covidSvc.getSintoma(enfermedad);
        if(sintoma != null)
            return new ResponseEntity<>(sintoma, HttpStatus.OK);
        else
            return  new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDto>> getPersonaRiesgo(){
        return new ResponseEntity<>(covidSvc.getPersonaRiesgo(), HttpStatus.OK);
    }
}
