package com.example.springconcesionariadeautos.controller;

import com.example.springconcesionariadeautos.dto.VehiculoDTO;
import com.example.springconcesionariadeautos.dto.VehiculoSinServiceDTO;
import com.example.springconcesionariadeautos.entity.Vehiculo;
import com.example.springconcesionariadeautos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiculoController {
    @Autowired
    private IVehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<VehiculoDTO> agregarVehiculo(@RequestBody VehiculoDTO vehiculoDTO){
        return ResponseEntity.ok(this.vehiculoService.agregarVehiculo(vehiculoDTO));
    }

    @GetMapping
    public ResponseEntity<List<VehiculoSinServiceDTO>> obtenerVehiculos(){
        return ResponseEntity.ok(this.vehiculoService.obtenerUsados());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehiculoDTO>> obtenerVehiculosSegunFechaDeFabricacion(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date desde, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date hasta){
        return ResponseEntity.ok(this.vehiculoService.obtenerListaDeVehiculosSegunFechaDeFabricacion(desde, hasta));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiculoDTO>> obtenervehiculosSegunPrecio(@RequestParam double desde, @RequestParam double hasta){
        return ResponseEntity.ok(this.vehiculoService.obtenerListaDeVehiculosSegunPrecio(desde, hasta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculoPorId(@PathVariable int id){
        return ResponseEntity.ok(this.vehiculoService.obtenerVehiculo(id));
    }
}
