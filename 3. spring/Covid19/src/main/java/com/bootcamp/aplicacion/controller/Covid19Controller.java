package com.bootcamp.aplicacion.controller;

import com.bootcamp.aplicacion.dto.PersonaDTO;
import com.bootcamp.aplicacion.dto.SintomaDTO;
import com.bootcamp.aplicacion.entities.Persona;
import com.bootcamp.aplicacion.service.CovidServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.aplicacion.service.CovidServicio;

import java.util.List;

@RestController
@RequestMapping
public class Covid19Controller {

    CovidServicio servicio = new CovidServicio();

    @GetMapping("findSymptom")
    public ResponseEntity<List<SintomaDTO>> listarSintomas(){
        return new ResponseEntity<>(servicio.listarSintomas(), HttpStatus.OK);
    }

    @GetMapping("findSymptom/{name}")
    public ResponseEntity<String> obtenerGravedad(@PathVariable String name){
        return new ResponseEntity<>(servicio.buscarNivelGravedadSintoma(name), HttpStatus.OK);
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> listarPersonas(){
        return new ResponseEntity<>(servicio.listarPersonasConSintomas(), HttpStatus.OK);
    }
}
