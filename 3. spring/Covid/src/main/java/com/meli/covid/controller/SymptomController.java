package com.meli.covid.controller;

import com.meli.covid.dto.SymptomDto;
import com.meli.covid.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomController {

    @Autowired
    ISymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> findSymptom() {
        return new ResponseEntity<>(symptomService.findSymptom(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> findSymptomByName(@PathVariable String name) {
        return new ResponseEntity<>(symptomService.findSymptomByName(name), HttpStatus.OK);
    }
}
