package com.vehiculo.api.controller;

import com.vehiculo.api.dto.BrandPatenteDto;
import com.vehiculo.api.dto.PatenteDto;
import com.vehiculo.api.dto.PatenteMarcaModeloDto;
import com.vehiculo.api.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/patente")
    public ResponseEntity<List<PatenteDto>> getPatentes(){
        return new ResponseEntity<>(vehiculoService.findAllPatentes(), HttpStatus.OK);
    }
    @GetMapping("/patente/marca")
    public ResponseEntity<List<BrandPatenteDto>> getBrandPatentes(){
        return new ResponseEntity<>(vehiculoService.findPatentesAndBrandOrderByYear(), HttpStatus.OK);
    }

    @GetMapping("/patente/wheels")
    public ResponseEntity<List<PatenteDto>> getPatentesWithVehiculesWithMoreThan4WheelsAndIsOfThisYear(){
        return new ResponseEntity<>(vehiculoService.findPatenteWithMoreThan4WheelsAndIsOfThisYear(), HttpStatus.OK);
    }
    @GetMapping("/patente/siniestro")
    public ResponseEntity<List<PatenteMarcaModeloDto>> getVehiculoWithBigSiniestro(){
        return new ResponseEntity<>(vehiculoService.getVehiculoWithBigSiniestro(), HttpStatus.OK);
    }
}
