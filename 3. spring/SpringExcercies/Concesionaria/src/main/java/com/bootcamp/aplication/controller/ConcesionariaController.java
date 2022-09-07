package com.bootcamp.aplication.controller;

import com.bootcamp.aplication.dto.CarDTO;
import com.bootcamp.aplication.dto.CarResponseDTO;
import com.bootcamp.aplication.service.ConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles")
public class ConcesionariaController {

    //POST  vehicles/
    //GET  vehicles/
    //GET  vehicles/dates?since=’’to=’’
    //GET  vehicles/prices?since=’’to=’’
    //GET  vehicles/{id}

    @Autowired
    ConcesionarioService concesionarioService;

    @PostMapping
    public ResponseEntity<CarDTO> uploadVehicle(@RequestBody CarDTO bodyRead) {

        return new ResponseEntity<>(concesionarioService.saveData(bodyRead), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> allVehicles() {
        return ResponseEntity.ok(concesionarioService.getAllCars());
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarResponseDTO>> sinceDate(@RequestParam(required = false) String order) {
        return ResponseEntity.ok(concesionarioService.findSinceDate(order));
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarResponseDTO>> sincePrice(@RequestParam(required = false) String order) {
        return ResponseEntity.ok(concesionarioService.findSincePrice(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable int id) {
        return ResponseEntity.ok(concesionarioService.findById(id));
    }
}
