package com.bootcamp.ejerciciospracticosp2vivo.controller;


import com.bootcamp.ejerciciospracticosp2vivo.dto.MealDto;
import com.bootcamp.ejerciciospracticosp2vivo.dto.MealDtoRequest;
import com.bootcamp.ejerciciospracticosp2vivo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MealController {

    @Autowired
    MealService mealService;

    @GetMapping("/meal/{name}/{weight}")
    public ResponseEntity<MealDto> findMeal(@PathVariable String name, @PathVariable Double weight){
        return new ResponseEntity<>(mealService.getMealByNameWeight(name, weight), HttpStatus.OK);
    }

    @PostMapping("/meals")
    public ResponseEntity<List<MealDto>> findMeals(@RequestBody List<MealDtoRequest> mealDtoRequests){
        return new ResponseEntity<>(mealService.getMeals(mealDtoRequests), HttpStatus.OK);
    }

}
