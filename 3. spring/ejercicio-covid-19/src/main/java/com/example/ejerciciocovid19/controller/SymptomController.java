package com.example.ejerciciocovid19.controller;

import com.example.ejerciciocovid19.model.Symptom;
import com.example.ejerciciocovid19.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {

    private final SymptomService symptomService;

    @Autowired
    public SymptomController(SymptomService symptomService) {
        this.symptomService = symptomService;
    }

    @GetMapping (path = "/findSymptom")
    public ResponseEntity<List<Symptom>> getSymptoms() {
        return ResponseEntity.ok(symptomService.getSymptoms());
    }

    @GetMapping (path = "/findSymptom/{name}")
    public ResponseEntity<?> getSymptom(@PathVariable String name) {
        Integer gravityLevel;
        try {
            gravityLevel = symptomService.getGravityLevelOfSymptomNamed(name);
            return ResponseEntity.ok(gravityLevel);
        } catch (RuntimeException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }

}
