package com.example.siniestros.controller;

import com.example.siniestros.dto.PatenteDto;
import com.example.siniestros.dto.PatenteMarcaDto;
import com.example.siniestros.dto.VehiculoDto;
import com.example.siniestros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {

    @Autowired
    private IVehiculoService service;

    @PostMapping("/create/vehiculo")
    public ResponseEntity<?> createVehiculos(@RequestBody VehiculoDto vehiculoDto){
        return new ResponseEntity<>(service.createVehiculo(vehiculoDto),HttpStatus.OK);
    }

    @PostMapping("/create/siniestro")
    public ResponseEntity<?> createSiniestro(@RequestBody SiniestroDto siniestroDto){
        return new ResponseEntity<>(service.createSiniestro(siniestroDto),HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<PatenteDto>> getPatentes(){
        return new ResponseEntity<>(service.findAllPantentes(), HttpStatus.OK);
    }

    @GetMapping("/patentes_marcas")
    public ResponseEntity<List<PatenteMarcaDto>> getPatentesAndMarcas(){
        return new ResponseEntity<>(service.findAllPatentesAndMarcas(), HttpStatus.OK);
    }

    @GetMapping("/patentes/mas4")
    public ResponseEntity<List<PatenteDto>> getPatentesWithMoreThan4Ruedas(){
        return new ResponseEntity<>(service.findAllPatentesWithMoreThan4Ruedas(), HttpStatus.OK);
    }




}
