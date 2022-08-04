package com.ejercicio.deportistas.controller;

import com.ejercicio.deportistas.dto.DeporteDTO;
import com.ejercicio.deportistas.dto.DeportistaDTO;
import com.ejercicio.deportistas.service.DeportistasAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasAppController {

    @Autowired
    private DeportistasAppService deportistaService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findAllSports() {
        return new ResponseEntity<>(deportistaService.findAllSports(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name) {
        DeporteDTO deporteDTO = deportistaService.findSportByName(name);
        if (deporteDTO != null)
            return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findAllSportsPersons() {
        return new ResponseEntity<>(deportistaService.findAllSportsPersons(), HttpStatus.OK);
    }
}
