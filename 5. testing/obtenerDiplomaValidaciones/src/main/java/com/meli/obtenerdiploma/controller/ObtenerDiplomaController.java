package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ObtenerDiplomaController {
    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public ResponseEntity<StudentDTO> analyzeScores(@Valid @RequestBody StudentDTO rq) {
        return new ResponseEntity<>(service.analyzeScores(rq), HttpStatus.OK);
    }
}
