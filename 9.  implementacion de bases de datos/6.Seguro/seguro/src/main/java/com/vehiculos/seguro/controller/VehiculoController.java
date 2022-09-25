package com.vehiculos.seguro.controller;

import com.vehiculos.seguro.dto.VehiculoDTO;
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

    @GetMapping("/aniofabric")
    public ResponseEntity<List<VehiculoDTO>> findAllOrderByAnioFabricacion(){
        return new ResponseEntity<>(vehiculoService.findAllOrderByAnioFabricacion(), HttpStatus.OK);
    }

    @GetMapping("/wheelsyear")
    public ResponseEntity<List<VehiculoDTO>> findAllWith4WheelsMadeThisYear(){
        return new ResponseEntity<>(vehiculoService.findAllWith4WheelsMadeThisYear(), HttpStatus.OK);
    }
}
