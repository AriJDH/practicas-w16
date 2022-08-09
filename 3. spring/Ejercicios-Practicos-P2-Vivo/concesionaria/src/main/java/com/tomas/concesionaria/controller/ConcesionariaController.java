package com.tomas.concesionaria.controller;

import com.tomas.concesionaria.dto.ListaVehiculoDTO;
import com.tomas.concesionaria.dto.VehiculoDTO;
import com.tomas.concesionaria.dto.MensajeDTO;
import com.tomas.concesionaria.service.IConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConcesionariaController {

    @Autowired
    IConcesionarioService concesionarioService;

    @PostMapping("v1/api/vehicles/")
    public ResponseEntity <MensajeDTO> registrarVehiculo(@RequestBody VehiculoDTO vehiculoDTO) {

        return new ResponseEntity<>(concesionarioService.agregarVehiculo(vehiculoDTO), HttpStatus.CREATED);

    }

    @GetMapping("v1/api/vehicles/")
    public ResponseEntity<ListaVehiculoDTO> listarVehiculo(){
        return new ResponseEntity<>(concesionarioService.listarVehiculo(), HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/{id}")
    public ResponseEntity<VehiculoDTO> consultarVehiculo(@PathVariable Long id) {
        return new ResponseEntity<>(concesionarioService.consultarVehiculo(id), HttpStatus.OK);
    }



}
