package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.NombreSintomaDTO;
import com.bootcamp.covid.dto.PersonaDTO;
import com.bootcamp.covid.dto.SintomaDTO;
import com.bootcamp.covid.dto.SintomasDTO;
import com.bootcamp.covid.service.ServiceCovid;
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
    private ServiceCovid serviceCovid;

    @GetMapping("/findSymptom")
    public ResponseEntity<SintomasDTO> getAllSintomas() {
        return  new ResponseEntity<>(serviceCovid.allSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> getSintoma(@PathVariable NombreSintomaDTO name) {
        return  new ResponseEntity<>(serviceCovid.getSintomaService(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    private ResponseEntity<List<PersonaDTO>> findRiskPerson(){
        return new ResponseEntity<>(serviceCovid.findRiskPerson(), HttpStatus.OK);
    }

}
