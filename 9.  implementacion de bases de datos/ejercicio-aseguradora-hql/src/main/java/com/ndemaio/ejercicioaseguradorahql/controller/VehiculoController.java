package com.ndemaio.ejercicioaseguradorahql.controller;

import com.ndemaio.ejercicioaseguradorahql.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (path = "/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping(path = "/anio")
    public ResponseEntity getOrdenadoPorAnio() {
        return ResponseEntity.ok(vehiculoService.getPatentesYMarcadsOrdenadasPorAnio());
    }

    @GetMapping(path = "/today")
    public ResponseEntity getRegistradosHoy() {
        return ResponseEntity.ok(vehiculoService.getPatentesDeVehiculosRegistradasHoy());
    }

    @GetMapping(path = "/perdidas")
    public ResponseEntity getPerdidasMayorA10000() {
        return ResponseEntity.ok(vehiculoService.getVehiculosConPerdidasMayorA10000());
    }

    @PostMapping (path = "/generate")
    public ResponseEntity createVehiculo() {
        vehiculoService.createVehiculos();
        return ResponseEntity.ok("creado");
    }

}
