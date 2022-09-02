package com.example.ejerciciosiniestros.controller;

import com.example.ejerciciosiniestros.dto.VehiculoPatenteDTO;
import com.example.ejerciciosiniestros.model.Vehiculo;
import com.example.ejerciciosiniestros.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehiculo")
public class VehiculoController {

    IVehiculoService vehiculoService;

    @Autowired
    public VehiculoController(IVehiculoService VehiculoService) {
        this.vehiculoService = VehiculoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculo(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.findVehiculoById(id));
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getVehiculos() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.findAllVehiculos());
    }

    @PostMapping("/new")
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo Vehiculo) {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.saveVehiculo(Vehiculo));
    }

    @PutMapping("/update")
    public ResponseEntity<Vehiculo> updateVehiculo(@RequestBody Vehiculo Vehiculo) {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.updateVehiculo(Vehiculo));
    }

    @DeleteMapping("delete/{id}")
    public void deleteVehiculo(@PathVariable long id) {
        vehiculoService.deleteVehiculo(id);
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<VehiculoPatenteDTO>> getPatentes() {
        return ResponseEntity.status(HttpStatus.OK).body(vehiculoService.getVehiculoPatentes());
    }
}
