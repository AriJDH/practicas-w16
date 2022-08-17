package com.example.obtenerdiploma.controller;

import com.example.obtenerdiploma.model.StudentDTO;
import com.example.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ObtenerDiplomaController {


    @Autowired
    IObtenerDiplomaService  service;


    @PostMapping("/analyzeScore")
    public ResponseEntity<StudentDTO> analyzeScore (@RequestBody @Valid StudentDTO studentDTO){
        return new ResponseEntity<>(service.analyzeScores(studentDTO), HttpStatus.OK);
    }
}
