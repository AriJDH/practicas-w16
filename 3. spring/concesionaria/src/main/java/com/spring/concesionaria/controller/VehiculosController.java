package com.spring.concesionaria.controller;

import com.spring.concesionaria.DTO.VehicleDTO;
import com.spring.concesionaria.entity.Vehicle;
import com.spring.concesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class VehiculosController {

    @Autowired
    IVehicleService iVehicleService;

    @GetMapping
    public ResponseEntity<List<VehicleDTO>> findAll(){
        return new ResponseEntity<>(iVehicleService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Boolean> add(@RequestBody VehicleDTO v){
        return new ResponseEntity<>(iVehicleService.add(v), HttpStatus.OK);
    }

    @GetMapping("/{model}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable String model){
        return new ResponseEntity<>(iVehicleService.findById(model), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<VehicleDTO>> findByDate(@RequestParam String since, @RequestParam String to){
        LocalDate date1 = LocalDate.parse(since);
        LocalDate date2 = LocalDate.parse(to);
        return new ResponseEntity<>(iVehicleService.findByDate(date1, date2), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<VehicleDTO>> findByPrice(@RequestParam Double since, @RequestParam Double to){
        return new ResponseEntity<>(iVehicleService.findByPrice(since, to), HttpStatus.OK);
    }

}
