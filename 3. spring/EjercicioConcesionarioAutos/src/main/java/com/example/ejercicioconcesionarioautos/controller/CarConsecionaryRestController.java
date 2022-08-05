package com.example.ejercicioconcesionarioautos.controller;

import com.example.ejercicioconcesionarioautos.dto.CarDto;
import com.example.ejercicioconcesionarioautos.dto.CarDtoWoService;
import com.example.ejercicioconcesionarioautos.service.ICarRepositoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CarConsecionaryRestController {

    @Autowired
    ICarRepositoryService carRepositoryService;

    @PostMapping("v1/api/vehicles")
    public void insertCar(@RequestBody CarDto car){
        carRepositoryService.insertCar(car);
    }

    @GetMapping("v1/api/vehicles")
    public ResponseEntity<List<CarDtoWoService>> getCarList(){
        return new ResponseEntity<>(carRepositoryService.getCarList(),HttpStatus.OK);
    }
    @GetMapping("v1/api/vehicles/dates")
    public ResponseEntity<List<CarDto>> getCarListByDate(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(carRepositoryService.getCarListByDate(LocalDate.parse(since),LocalDate.parse(to)),HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/prices")
    public ResponseEntity<List<CarDto>> getCarListByPrice(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>(carRepositoryService.getCarListByPrice(Integer.parseInt(since),Integer.parseInt(to)),HttpStatus.OK);
    }

    @GetMapping("v1/api/vehicles/{id}")
    public ResponseEntity<CarDto> getCarListByDate(@PathVariable String id){
        return new ResponseEntity<>(carRepositoryService.getCarById(Integer.parseInt(id)),HttpStatus.OK);
    }


}
