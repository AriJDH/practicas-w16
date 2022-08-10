package com.example.springstarwars.controller;

import com.example.springstarwars.dto.RequestPersonajeDTO;
import com.example.springstarwars.dto.ResponsePersonajeDTO;
import com.example.springstarwars.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Ejercicio > Modulo 8: Spring > ArquitecturaMulticapa-P1-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class Controller {
    @Autowired
    private Service service;

    @PostMapping("/load-characters")
    public ResponseEntity<String> loadCharacters(@RequestBody List<RequestPersonajeDTO> body) {
        this.service.cargarPersonajes(body);
        return new ResponseEntity<>("Carga ok", HttpStatus.OK);
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity<List<ResponsePersonajeDTO>> getName(@PathVariable String name) {
        return new ResponseEntity<>(service.getPersonaje(name), HttpStatus.OK);
    }
}
