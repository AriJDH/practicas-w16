package com.ejemplo.covid.controller;

import com.ejemplo.covid.dto.ReqSintomaDTO;
import com.ejemplo.covid.dto.ResPersonaDTO;
import com.ejemplo.covid.dto.ResSintomaDTO;
import com.ejemplo.covid.dto.SintomaDTO;
import com.ejemplo.covid.service.CovidService;
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
    public ResponseEntity<SintomaDTO> findSymptom() {
        return new ResponseEntity<>(covidService.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{sintoma}")
    public ResponseEntity<ResSintomaDTO> findSymptom(@PathVariable ReqSintomaDTO sintoma) {
        return new ResponseEntity<>(covidService.findSymptom(sintoma), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<ResPersonaDTO>> findRiskPerson() {
        return new ResponseEntity<>(covidService.findRiskPerson(), HttpStatus.OK);
    }

}
