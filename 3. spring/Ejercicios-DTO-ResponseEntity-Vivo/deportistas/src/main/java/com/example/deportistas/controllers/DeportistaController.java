package com.example.deportistas.controllers;

import com.example.deportistas.dtos.DeporteDto;
import com.example.deportistas.dtos.DeportistaDto;
import com.example.deportistas.services.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {

    @Autowired
    private DeporteService service;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> obtenerTodosDeportes(){

        return new ResponseEntity<>(service.obtenerTodosDeportes(), HttpStatus.OK);

    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDto> consultarDeporte(@PathVariable String name){

        return new ResponseEntity<>(service.obtenerDeporte(name), HttpStatus.OK);

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDto>> consultarPersonas(){

        return new ResponseEntity<>(service.obtenerDeportePersona(), HttpStatus.OK);

    }

}
