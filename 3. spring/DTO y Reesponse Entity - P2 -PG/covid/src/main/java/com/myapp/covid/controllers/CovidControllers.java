package com.myapp.covid.controllers;

import com.myapp.covid.dtos.PatientDTO;
import com.myapp.covid.dtos.SymptomDTO;
import com.myapp.covid.services.CovidServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class CovidControllers {
    private CovidServices covidServices = new CovidServices();

    public CovidControllers(CovidServices covidServices){
        this.covidServices = covidServices;
    }

    //PATH: /findSymptom
    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDTO>> getAllSports(){

        try {
            return new ResponseEntity<>(covidServices.getAllSymptom(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //PATH: /findSymptom/{name}
    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDTO> findSymptom(@PathVariable String name) {
        try {
            return new ResponseEntity<>(covidServices.findSymptom(name), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PATH: /findRiskPerson
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PatientDTO>> findSportsPerson() {
        try {
            return new ResponseEntity<>(covidServices.findRiskPerson(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
