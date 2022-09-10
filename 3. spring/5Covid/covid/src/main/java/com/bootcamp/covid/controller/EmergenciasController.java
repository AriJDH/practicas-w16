package com.bootcamp.covid.controller;

import com.bootcamp.covid.DTO.RiesgoDTO;
import com.bootcamp.covid.DTO.PersonaDTO;
import com.bootcamp.covid.DTO.SintomaDTO;
import com.bootcamp.covid.services.ISintomasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmergenciasController {

    @Autowired
    ISintomasServices iSintomasServices;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> listaDeSintomas(){
        return new ResponseEntity<>(iSintomasServices.getAllSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findPersons")
    public ResponseEntity<List<PersonaDTO>> listaDePersonas(){
        return new ResponseEntity<>(iSintomasServices.getAllPersonas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<List<SintomaDTO>> listaDeSintoma(@PathVariable String name){
        return new ResponseEntity<>(iSintomasServices.getSintomaByName(name), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<RiesgoDTO>> listaGrupoDeRiesgo(){
        return new ResponseEntity<>(iSintomasServices.listaGrupoDeRiesgo(),HttpStatus.OK);
    }
}
