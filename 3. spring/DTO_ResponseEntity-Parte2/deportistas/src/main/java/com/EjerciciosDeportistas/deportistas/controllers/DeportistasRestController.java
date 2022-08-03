package com.EjerciciosDeportistas.deportistas.controllers;


import com.EjerciciosDeportistas.deportistas.DTOs.DeporteDTO;
import com.EjerciciosDeportistas.deportistas.entities.Deporte;
import com.EjerciciosDeportistas.deportistas.services.DeportistasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSports")
public class DeportistasRestController {

    //Llamar al servicio
    @Autowired
    private DeportistasService servicio;

    @GetMapping
    public ResponseEntity<List<DeporteDTO>> listarDeportes(){
        return new ResponseEntity<>(servicio.listarDeportes(), HttpStatus.OK);
    }

    @GetMapping("{nombre}")
    public ResponseEntity<DeporteDTO> consultarDeporte(@PathVariable String nombre){
        return new ResponseEntity<>(servicio.consultarDeporte(nombre), HttpStatus.OK);
    }

}
