package com.bootcamp.ejerciciovehiculossiniestros.controller;

import com.bootcamp.ejerciciovehiculossiniestros.dto.VehiculoDto;
import com.bootcamp.ejerciciovehiculossiniestros.service.IServiceVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehiculoController {

    @Autowired
    IServiceVehiculo serviceVehiculo;

    @PostMapping("/crearvehiculo")
    public ResponseEntity<?> crearVehiculo(@RequestBody VehiculoDto vehiculoDto) {
        serviceVehiculo.crearVehiculo(vehiculoDto);
        return ResponseEntity.ok(null);

    }

    @GetMapping("/obtenervehiculo/{patente}")
    public ResponseEntity<VehiculoDto> consultarVehiculoPorPatente(@PathVariable String patente){
        return new ResponseEntity<>(serviceVehiculo.obtenerVehiculoPorPatente(patente),HttpStatus.OK);
    }

    @GetMapping("/obtenerPatentes")
    public ResponseEntity<?> obtenerPatentes(){
        return new ResponseEntity<>(serviceVehiculo.obtenerTodasLasPatentes(),HttpStatus.OK);
    }

    @GetMapping("/obtenerOrdenado")
    public ResponseEntity<?> obtenerOrdenado(){
        return new ResponseEntity<>(serviceVehiculo.obtenerOrdenado(),HttpStatus.OK);
    }
    @GetMapping("/obtener4ruedas")
    public ResponseEntity<?> obtener4RuedasYAñoCorriente(){
        return new ResponseEntity<>(serviceVehiculo.obtener4RuedasYAñoCorriente(),HttpStatus.OK);
    }




}
