package com.spring.covid19.controllers;

import com.spring.covid19.DTOs.PersonaDTO;
import com.spring.covid19.DTOs.SintomaDTO;
import com.spring.covid19.services.Covid19Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Covid19Controller {

    @Autowired
    Covid19Service service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> listarSintomas(){
        return new ResponseEntity<>(service.listarSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> listarSintomaxNombre(@PathVariable String name){
        return new ResponseEntity<>(service.listarSintomaxNombre(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> listarPersonasGrupoRiesgo(){
        return new ResponseEntity<>(service.listarPersonasGrupoRiesgo(), HttpStatus.OK);
    }

}
