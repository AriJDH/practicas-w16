package com.bootcamp.seguro.controller;

import com.bootcamp.seguro.dto.PatenteDto;
import com.bootcamp.seguro.dto.VehiculoDto;
import com.bootcamp.seguro.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehiculos")
public class VehiculoController {
    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping("{id}")
    public ResponseEntity<VehiculoDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(vehiculoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehiculoDto>> findAll(VehiculoDto vehiculoDto) {
        return ResponseEntity.ok().body(vehiculoService.findAll(vehiculoDto));
    }

    @GetMapping("/perdidas")
    public ResponseEntity<List<PatenteDto>> findAllBySiniestrosWherePerdidaEconomicaGreaterThan10000() {
        return ResponseEntity.ok().body(vehiculoService.findAllBySiniestrosWherePerdidaEconomicaGreaterThan10000());
    }

    @GetMapping("/perdidas/actual")
    public ResponseEntity<List<VehiculoDto>> findAllWhereCantidadRuedasGreaterThan4AndIsCurrentAnioFabricacion() {
        return ResponseEntity.ok().body(vehiculoService.findAllWhereCantidadRuedasGreaterThan4AndIsCurrentAnioFabricacion());
    }

    @PostMapping
    public ResponseEntity<VehiculoDto> save(@RequestBody VehiculoDto vehiculoDto) {
        return ResponseEntity.ok().body(vehiculoService.save(vehiculoDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<VehiculoDto> update(@PathVariable Long id, @RequestBody VehiculoDto vehiculoDto) {
        return ResponseEntity.ok().body(vehiculoService.update(id, vehiculoDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        vehiculoService.delete(id);
        return ResponseEntity.ok().body(null);
    }
}
