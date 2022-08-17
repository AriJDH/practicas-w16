package com.diploma.diploma.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.service.IObtenerDiplomaService;

@RestController
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public ResponseEntity<?> analyzeScores(@RequestBody @Valid StudentDTO rq) {
        return ResponseEntity.ok(null);
    }
}