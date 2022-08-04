package com.example.ejercicio2.controllers;


import com.example.ejercicio2.entitisDto.PersonaDTO;
import com.example.ejercicio2.entitisDto.SintomaDTO;
import com.example.ejercicio2.services.SintomasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SintomasControllers {
    @Autowired
    private SintomasServices sintomasServices;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getAllSintoma(){

        return new ResponseEntity<>(sintomasServices.getAllSintomasTotales(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> getSintoma(@PathVariable String nombre){
        return new ResponseEntity<>(sintomasServices.getSintoma(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> getPersonasDeRiesgo(){
        return new ResponseEntity<>(sintomasServices.getPersonaWithSintoma(), HttpStatus.OK);
    }
}
