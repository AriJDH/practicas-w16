package com.example.ejdeportistas.controllers;

import com.example.ejdeportistas.dtos.DeporteDto;
import com.example.ejdeportistas.dtos.PersonaDto;
import com.example.ejdeportistas.services.DeporteService;
import com.example.ejdeportistas.services.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistaController {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> getDeportes() {

        DeporteService deporteService = new DeporteService();

        return new ResponseEntity<>(deporteService.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDto> getDeporte(@PathVariable String name) {

        DeporteService deporteService = new DeporteService();

        DeporteDto deporte = deporteService.getDeportes().stream().filter(d -> d.getDeporte().getNombre().equals(name)).findFirst().orElse(null);

        return new ResponseEntity<>(deporte, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons/{name}")
    public ResponseEntity<List<PersonaDto>> getPersonas(@PathVariable String name) {

        PersonaService personaService = new PersonaService();
        var personas = personaService.getPersonasDeporte(name);

        return new ResponseEntity<>(personas, HttpStatus.OK);
    }
}
