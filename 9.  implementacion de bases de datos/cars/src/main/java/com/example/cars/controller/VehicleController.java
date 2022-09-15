package com.example.cars.controller;

import com.example.cars.dto.PatentsAndBrandDTO;
import com.example.cars.dto.PatentsDTO;
import com.example.cars.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @GetMapping("/1")
    public ResponseEntity<List<PatentsDTO>> findAllPatents() {
        return new ResponseEntity<>(this.vehicleService.findAllPatents(), HttpStatus.OK);
    }
    @GetMapping("/2")
    public ResponseEntity<List<PatentsAndBrandDTO>> findAllByOrderByYearOfProduction() {
        return new ResponseEntity<>(this.vehicleService.findAllByOrderByYearOfProduction(), HttpStatus.OK);
    }
}
