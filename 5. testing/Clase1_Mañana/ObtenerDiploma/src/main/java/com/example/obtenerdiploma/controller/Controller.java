package com.example.obtenerdiploma.controller;

import com.example.obtenerdiploma.DTO.ResponseDTO;
import com.example.obtenerdiploma.DTO.StudentDTO;
import com.example.obtenerdiploma.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller {
    @Autowired
    IService service;
    @PostMapping("/average")
    public ResponseEntity<ResponseDTO> calculate(@Valid @RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(service.calculateAverage(studentDTO), HttpStatus.OK);
    }
}
