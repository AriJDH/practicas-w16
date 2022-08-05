package com.example.deportistas.controllers;

import com.example.deportistas.dto.DeportistaDTO;
import com.example.deportistas.dto.NivelDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.deportistas.services.DeporteService;
import com.example.deportistas.dto.DeporteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class DeporteController {
    @Autowired
    private DeporteService servicio;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        List<DeporteDTO> deportes = servicio.obtenerDeportes();
        return new ResponseEntity<>(deportes, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<NivelDTO> findSportByName(@PathVariable String name){
        return new ResponseEntity<>(servicio.obtenerNivelDeporteXNombre(name), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> findSportPersons(){
        return new ResponseEntity<>(servicio.obtenerDeportistas(), HttpStatus.ACCEPTED);
    }



}
