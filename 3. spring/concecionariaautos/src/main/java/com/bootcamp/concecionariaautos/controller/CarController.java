package com.bootcamp.concecionariaautos.controller;


import com.bootcamp.concecionariaautos.dto.CarDTO;
import com.bootcamp.concecionariaautos.models.Car;
import com.bootcamp.concecionariaautos.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")

public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public void addCar(@RequestBody Car car){
        carService.addCar(car);
    }

    @GetMapping
    public List<CarDTO> getCars(){
        return carService.getAllCars();
    }

    @GetMapping("dates")
    public List<Car> getCarsByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                   @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return carService.getCarsByDate(since,to);
    }

    @GetMapping("prices")
    public List<Car> getCarsBetweenPrices (@RequestParam Double since, @RequestParam Double to){
        return carService.getCarsByPrice(since, to);
    }

    @GetMapping("{id}")
    public Car getCarById(@PathVariable Long id){
        return carService.getCarById(id);
    }
}
