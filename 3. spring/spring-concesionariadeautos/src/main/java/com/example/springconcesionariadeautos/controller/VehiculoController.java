package com.example.springconcesionariadeautos.controller;

import com.example.springconcesionariadeautos.dto.VehiculoDTO;
import com.example.springconcesionariadeautos.dto.VehiculoSinServiceDTO;
import com.example.springconcesionariadeautos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*
 * Ejercicio > Modulo 8: Spring > EjerciciosPracticos-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
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
    public ResponseEntity<List<VehiculoSinServiceDTO>> obtenerListaDeVehiculosUsados(){
        return ResponseEntity.ok(this.vehiculoService.obtenerVehiculosUsados());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehiculoDTO>> obtenerListaDeVehiculosSegunFechaDeFabricacion(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return ResponseEntity.ok(this.vehiculoService.obtenerListaDeVehiculosSegunFechaDeFabricacion(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehiculoDTO>> obtenerListaDeVehiculosSegunPrecio(@RequestParam double since, @RequestParam double to){
        return ResponseEntity.ok(this.vehiculoService.obtenerListaDeVehiculosSegunPrecio(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> obtenerVehiculoPorId(@PathVariable int id){
        return ResponseEntity.ok(this.vehiculoService.obtenerVehiculo(id));
    }
}
