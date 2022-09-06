package com.bootcamp.autos.controller;

import com.bootcamp.autos.dto.VehiculoPatentesDto;
import com.bootcamp.autos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<List<VehiculoPatentesDto>> getPatentes() {
        return new ResponseEntity<>(vehiculoService.getPatentesVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patentes/marcas")
    public ResponseEntity<?> getPatentesMarcas() {
        return new ResponseEntity<>(vehiculoService.getPatenteMarcaVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patentes/ruedas/anio")
    public ResponseEntity<List<VehiculoPatentesDto>> getPatentesRuedasAnio() {
        return new ResponseEntity<>(vehiculoService.getPatentesByFechaByRuedaVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/siniestro")
    public ResponseEntity<List<HashMap<String, String>>> getVehiculosSiniestros() {
        return new ResponseEntity<>(vehiculoService.getVehiculosSiniestro(), HttpStatus.OK);
    }

}
