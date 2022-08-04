package com.ejercicio.covid.controller;

import com.ejercicio.covid.dto.PersonaDTO;
import com.ejercicio.covid.dto.SintomaDTO;
import com.ejercicio.covid.service.CovidService;
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
    private CovidService covidService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findAllSymptom() {
        return new ResponseEntity<>(covidService.findAllSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> findSymptomByName(@PathVariable String name) {
        SintomaDTO res = covidService.findSymptomByName(name);
        if (res != null)
            return new ResponseEntity<>(res, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> findRiskPerson() {
        return new ResponseEntity<>(covidService.findRiskPerson(), HttpStatus.OK);
    }
}
