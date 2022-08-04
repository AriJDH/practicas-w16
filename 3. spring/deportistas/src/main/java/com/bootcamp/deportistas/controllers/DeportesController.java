package com.bootcamp.deportistas.controllers;


import com.bootcamp.deportistas.dtos.DeporteDto;
import com.bootcamp.deportistas.dtos.NivelDeporteDTO;
import com.bootcamp.deportistas.dtos.PersonaDto;
import com.bootcamp.deportistas.service.DeportistasSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController  {

    @Autowired
    private DeportistasSvc service;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> allSports(){
        return new ResponseEntity<>(service.listarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<List<NivelDeporteDTO>> findSport(@PathVariable String name){
        return new ResponseEntity<>(service.buscarDeporte(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDto>> findSport(){
        return new ResponseEntity<>(service.listarPersonas(), HttpStatus.OK);
    }
}
