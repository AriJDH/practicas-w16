package com.bootcamp.practico.controller;

import com.bootcamp.practico.dto.RequestPersonajeDTO;
import com.bootcamp.practico.dto.ResponsePersonajeDto;
import com.bootcamp.practico.service.IPersonajeService;
import com.bootcamp.practico.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private final IPersonajeService service;

    @Autowired
    public Controller(IPersonajeService service) {
        this.service = service;
    }


    @PostMapping("/carga")
    public ResponseEntity<String> cargaPersonaje(@RequestBody List<RequestPersonajeDTO> body) {

        service.cargaPersonajes(body);
        return new ResponseEntity<>("carga ok", HttpStatus.OK);


    }

    @GetMapping("/getName/{name}")
    public ResponseEntity<List<ResponsePersonajeDto>> getName(@PathVariable String name) {

        return new ResponseEntity<>(service.getPersonajesByName(name), HttpStatus.OK);
    }
}
