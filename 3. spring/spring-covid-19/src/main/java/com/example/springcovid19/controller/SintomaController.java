package com.example.springcovid19.controller;

import com.example.springcovid19.entityDTO.PersonaDTO;
import com.example.springcovid19.entityDTO.SintomaDTO;
import com.example.springcovid19.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * Ejercicio > Modulo 8: Spring > DTOYResponseEntity-P2-PG
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController

public class SintomaController {
    @Autowired
    private Service sintomaService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getAllSintomas(){
        return new ResponseEntity<>(this.sintomaService.getAllSintomas(), HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{nombre}")
    public ResponseEntity<SintomaDTO> getSintoma(@PathVariable String nombre){
        return new ResponseEntity<>(this.sintomaService.getSintoma(nombre), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> getPersonasDeRiesgo(){
        return new ResponseEntity<>(this.sintomaService.getPersonaWithSintoma(), HttpStatus.OK);
    }
}
