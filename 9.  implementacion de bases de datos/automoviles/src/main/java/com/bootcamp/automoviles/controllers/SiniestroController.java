package com.bootcamp.automoviles.controllers;

import com.bootcamp.automoviles.dto.SiniestroDTO;
import com.bootcamp.automoviles.dto.Siniestro_DTO;
import com.bootcamp.automoviles.services.ISiniestroService;
import com.bootcamp.automoviles.services.SiniestroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siniestros")
public class SiniestroController {

    private final ISiniestroService siniestroService;

    @Autowired
    public SiniestroController(SiniestroService siniestroService) {
        this.siniestroService = siniestroService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody Siniestro_DTO siniestroDTO) {
        return new ResponseEntity<>(siniestroService.create(siniestroDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> find() {
        return new ResponseEntity<>(siniestroService.find(),HttpStatus.OK);
    }

}
