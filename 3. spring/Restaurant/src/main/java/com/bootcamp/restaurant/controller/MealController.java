package com.bootcamp.restaurant.controller;

import com.bootcamp.restaurant.dto.MealDto;
import com.bootcamp.restaurant.dto.MealDtoRequest;
import com.bootcamp.restaurant.service.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MealController {

    @Autowired
    MealServiceImpl service;

    @GetMapping("/meal/{name}/{weight}")
    public ResponseEntity<MealDto> findMeal(@PathVariable String name, @PathVariable Double weight){
        return new ResponseEntity<>(service.getMealByNameWeight(name, weight), HttpStatus.OK);
    }

    @PostMapping("/meals")
    public ResponseEntity<List<MealDto>> findMeals(@RequestBody List<MealDtoRequest> mealsRequest){
        return new ResponseEntity<>(service.getMeals(mealsRequest), HttpStatus.OK);
    }

}
