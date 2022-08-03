package com.bootcamp.deportes.controllers;

import com.bootcamp.deportes.dtos.DeporteDTO;
import com.bootcamp.deportes.dtos.PersonaDTO;
import com.bootcamp.deportes.services.DeporteServices;
import com.bootcamp.deportes.services.PersonaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DeportesController {

    @Autowired
    DeporteServices deporteServices;
    @Autowired
    PersonaServices personaServices;

    @GetMapping("findSports")
    public ResponseEntity<List<DeporteDTO>> verDeportes(){
        return new ResponseEntity<>(deporteServices.devolverDeportes(), HttpStatus.OK);
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<Integer> buscarDeporte(@PathVariable String name){
        int nivel = deporteServices.devolverNivelDeporte(name);
        if (nivel <= 0){
            return new ResponseEntity<>(0, HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(nivel, HttpStatus.OK);
        }
    }

    @GetMapping("findSportsPerson")
    public ResponseEntity<List<PersonaDTO>> findSportsPerson(){
        return new ResponseEntity<>(personaServices.devolverDeportistas(), HttpStatus.OK);
    }
}
