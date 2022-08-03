package com.spring.deportistas.controllers;

import com.spring.deportistas.DTOs.DeporteDTO;
import com.spring.deportistas.DTOs.PersonaDTO;
import com.spring.deportistas.entities.Persona;
import com.spring.deportistas.services.DeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSports")
public class DeportistasController {

    @Autowired
    DeportistasService deportistasService;

    @GetMapping
    public ResponseEntity<List<DeporteDTO>> listarDeportes(){
        return new ResponseEntity<>(deportistasService.listarDeportes(), HttpStatus.OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<DeporteDTO> listarDeportexNombre(@PathVariable String nombre){
        return new ResponseEntity<>(deportistasService.listarDeportexNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/Persons")
    public ResponseEntity<List<PersonaDTO>> listarPersonas(){
        return new ResponseEntity<>(deportistasService.listarPersonas(), HttpStatus.OK);
    }

}
