package com.vehiculos.seguro.controller;

import com.vehiculos.seguro.dto.VehiculoPatenteDTO;
import com.vehiculos.seguro.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seguro")
public class VehiculoController {
    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/vehiculos")
    public ResponseEntity<List<VehiculoPatenteDTO>> listAllByPatente(){
        return new ResponseEntity<>(vehiculoService.listAllByPatente(), HttpStatus.OK);
    }
}
