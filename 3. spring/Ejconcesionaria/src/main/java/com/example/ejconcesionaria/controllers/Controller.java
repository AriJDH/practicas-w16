package com.example.ejconcesionaria.controllers;

import com.example.ejconcesionaria.dtos.VehicleDto;
import com.example.ejconcesionaria.model.Vehicle;
import com.example.ejconcesionaria.services.IVehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("/api")
public class Controller {

    @Autowired
    IVehicleServices vehicleServices;

    @PostMapping("/vehicle")
    public ResponseEntity<VehicleDto> addVehicle(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleServices.addVehicle(vehicle));
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {
        return ResponseEntity.ok(vehicleServices.getVehicle(id));
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        return ResponseEntity.ok(vehicleServices.getAllVehicles());
    }

    @GetMapping("/vehicles/price")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByPrice(@RequestParam double since, @RequestParam double to) {
        return ResponseEntity.ok(vehicleServices.getAllVehiclesByPrice(since,to));
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehicleDto>> getAllVehiclesByDates(@RequestParam Date since, @RequestParam Date to) {
        return ResponseEntity.ok(vehicleServices.getAllVehiclesByDates(since,to));
    }
}
