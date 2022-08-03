package com.bootcamp.covidapi.controllers;

import com.bootcamp.covidapi.dto.SintomaDto;
import com.bootcamp.covidapi.services.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SintomaController {

    @Autowired
    private SintomaService sintomaService;

    @GetMapping("/findSymptom")
    private ResponseEntity<List<SintomaDto>> getSymptoms(){
        return new ResponseEntity<>(sintomaService.getSymptoms(), HttpStatus.OK);
    }
    @GetMapping("/findSymptom/{name}")
    private ResponseEntity<?> findSeverityLevelBySymptomName(@PathVariable String name){
        Map<String, Object> response = new HashMap<>();
        response.put("Nivel de severidad", sintomaService.findSymptoms(name).getNIVEL_DE_GRAVEDAD());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    private ResponseEntity<?> findRiskPerson(){

        return new ResponseEntity<>(sintomaService.findRiskPerson(), HttpStatus.OK);
    }
}
