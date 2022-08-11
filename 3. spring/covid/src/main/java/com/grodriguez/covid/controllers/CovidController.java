package com.grodriguez.covid.controllers;

import com.grodriguez.covid.dtos.NivelDTO;
import com.grodriguez.covid.dtos.PersonaRiesgoDTO;
import com.grodriguez.covid.dtos.SintomaDTO;
import com.grodriguez.covid.entities.Persona;
import com.grodriguez.covid.entities.Sintoma;
import com.grodriguez.covid.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CovidController {

    @Autowired
    private CovidService service;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> getSintomas(){
        List<SintomaDTO> sintomas = service.getSintomas().stream()
                .map(x -> new SintomaDTO(x.getCodigo(), x.getNombre(), x.getNivel_de_gravedad()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<NivelDTO> getSintoma(@PathVariable String name){
        NivelDTO n = new NivelDTO(service.getSintoma(name));
        return new ResponseEntity<>(n, HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<PersonaRiesgoDTO> getPersonasRiesgo(){

        List<Persona> personas = service.getPersonas();
        List<PersonaRiesgoDTO> personasRiesgo = personas.stream()
                .filter(x -> x.getEdad() > 60)
                .map(x -> new PersonaRiesgoDTO(x.getNombre(), x.getApellido(), x.getSintoma().getNombre()))
                .collect(Collectors.toList());

        return new ResponseEntity(personasRiesgo, HttpStatus.OK);
    }
}
