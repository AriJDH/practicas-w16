package com.bootcamp.aplicacion.controller;

import com.bootcamp.aplicacion.dto.DeporteDTO;
import com.bootcamp.aplicacion.dto.PersonaDTO;
import com.bootcamp.aplicacion.services.SportServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class DeportistasController {

    SportServices servicio = new SportServices();

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> listarDeportes(){
        return new ResponseEntity<>(servicio.listarDeportes(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSports/{nombre}")
    public ResponseEntity<DeporteDTO> listarDeportesPorNombre(@PathVariable String nombre){
        return new ResponseEntity<>(servicio.obtenerDeportePorNombre(nombre), HttpStatus.ACCEPTED);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> listarPersonas(){
        return new ResponseEntity<>(servicio.listarPersonas(), HttpStatus.ACCEPTED);
    }
}
