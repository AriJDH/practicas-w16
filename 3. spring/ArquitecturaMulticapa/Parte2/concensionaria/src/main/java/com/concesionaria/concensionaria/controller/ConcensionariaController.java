package com.concesionaria.concensionaria.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concesionaria.concensionaria.dto.VehicleDTO;
import com.concesionaria.concensionaria.entity.VehicleEntity;
import com.concesionaria.concensionaria.service.VehicleService;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcensionariaController {
    @Autowired
    private final VehicleService vehicleService;

    public ConcensionariaController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    //Routes

    @GetMapping("/")
    public ResponseEntity<List<VehicleDTO>> getVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

    @PostMapping("/")
    public ResponseEntity<String> createVehicle(@RequestBody VehicleEntity vehicle) {
        return ResponseEntity.ok(vehicleService.addVehicle(vehicle) ? "Vehicle created" : "Vehicle not created");
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByDate(@RequestParam Date since, @RequestParam Date to) {
        return ResponseEntity.ok(vehicleService.getVehiclesByDate(since, to));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> getVehiclesByPrice(@RequestParam Double since, @RequestParam Double to) {
        return ResponseEntity.ok(vehicleService.getVehiclesByPrice(since, to));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable String id) {
        VehicleDTO vehicle = vehicleService.getVehicleById(id);
        
        if(vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vehicle);
    }
}
