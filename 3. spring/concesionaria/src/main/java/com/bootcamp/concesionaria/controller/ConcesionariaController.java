package com.bootcamp.concesionaria.controller;

import com.bootcamp.concesionaria.dto.CarDto;
import com.bootcamp.concesionaria.dto.CarRequestDto;
import com.bootcamp.concesionaria.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaController {

    @Autowired
    CarsService carsService;

    @PostMapping("")
    public ResponseEntity<String> addCar(@RequestBody CarRequestDto car){
        carsService.addCar(car);
        return new ResponseEntity<>("Auto agregado correctamente", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CarDto>> getCars(){
        return new ResponseEntity<>(carsService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<List<CarDto>> getCars(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(carsService.getCars(since, to), HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<List<CarDto>> getPriceCars(@RequestParam String from, @RequestParam String to){
        return new ResponseEntity<>(carsService.getCarsPrice(from, to), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable int id){
        return new ResponseEntity<>(carsService.getCar(id), HttpStatus.OK);
    }
}
