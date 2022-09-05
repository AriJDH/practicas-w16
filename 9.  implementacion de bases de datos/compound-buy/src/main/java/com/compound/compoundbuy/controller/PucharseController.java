package com.compound.compoundbuy.controller;

import com.compound.compoundbuy.DTO.PucharseCreateDTO;
import com.compound.compoundbuy.service.IPucharseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PucharseController {

    @Autowired
    IPucharseService pucharseService;

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody PucharseCreateDTO pucharseCreateDTO) {
        PucharseCreateDTO response = pucharseService.create(pucharseCreateDTO);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
