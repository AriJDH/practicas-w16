package com.tomas.covid.controllers;

import com.tomas.covid.dtos.ListaPersonaDto;
import com.tomas.covid.dtos.ListaSintomaDto;
import com.tomas.covid.dtos.SintomaGravedadDto;
import com.tomas.covid.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CovidController {

    @Autowired
    private CovidService serviceCovid;

    @GetMapping("/findSymptom")
    public ResponseEntity<ListaSintomaDto> findSymptom(){

        return new ResponseEntity<>(serviceCovid.obtenerTodoSintoma(), HttpStatus.OK);

    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaGravedadDto> findSymptom(@PathVariable String name) {

        return new ResponseEntity<>(serviceCovid.obtenerSintomaEspecifico(name), HttpStatus.OK);

    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<ListaPersonaDto> findRiskPerson() {

        return new ResponseEntity<>(serviceCovid.obtenerPersonaRiesgo(), HttpStatus.OK);

    }

}
