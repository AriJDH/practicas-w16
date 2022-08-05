package com.example.covid19.controller;

import com.example.covid19.dto.NivelSintomaDTO;
import com.example.covid19.dto.PersonaRiesgoDTO;
import com.example.covid19.dto.SintomaDTO;
import com.example.covid19.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/covid")
public class CovidController {

    @Autowired
    private CovidService service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> obtenerSintomas() {
        return new ResponseEntity<>(service.obtenerSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Optional<NivelSintomaDTO>> obtenerSintomas(@PathVariable String name) {
        return new ResponseEntity<>(service.obtenerNivelSintoma(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPersons")
    public ResponseEntity<List<PersonaRiesgoDTO>> obtenerPersonasRiesgo() {
        return new ResponseEntity<>(service.obtenerPersonasRiesgo(), HttpStatus.OK);
    }

}
