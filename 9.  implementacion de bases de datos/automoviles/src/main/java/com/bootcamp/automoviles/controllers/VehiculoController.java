package com.bootcamp.automoviles.controllers;

import com.bootcamp.automoviles.dto.VehiculoDTO;
import com.bootcamp.automoviles.services.IVehiculoService;
import com.bootcamp.automoviles.services.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create(@RequestBody VehiculoDTO vehiculoDTO) {
        return new ResponseEntity<>(vehiculoService.create(vehiculoDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> find() {
        return new ResponseEntity<>(vehiculoService.find(),HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> findPatentes() {
        return new ResponseEntity<>(vehiculoService.findPatentes(),HttpStatus.OK);
    }
    @GetMapping("/modelo/marca")
    public ResponseEntity<?> findModeloMarca() {
        return new ResponseEntity<>(vehiculoService.findPatenteYMarca(),HttpStatus.OK);
    }

    @GetMapping("/ruedas")
    public ResponseEntity<?> findMoreThan4Wheel() {
        return new ResponseEntity<>(vehiculoService.findMoreThan4Wheels(),HttpStatus.OK);
    }

    @GetMapping("/lost")
    public ResponseEntity<?> findLostMoreThan10000() {
        return new ResponseEntity<>(vehiculoService.findLostMoreThan10000(),HttpStatus.OK);
    }

    @GetMapping("/lost/acc")
    public ResponseEntity<?> findLostMoreThan10000Vehicule() {
        return new ResponseEntity<>(vehiculoService.findTotales(),HttpStatus.OK);
    }


}
