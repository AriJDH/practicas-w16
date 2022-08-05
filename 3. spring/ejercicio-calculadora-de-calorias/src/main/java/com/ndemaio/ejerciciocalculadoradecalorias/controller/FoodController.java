package com.ndemaio.ejerciciocalculadoradecalorias.controller;

import com.ndemaio.ejerciciocalculadoradecalorias.entity.Food;
import com.ndemaio.ejerciciocalculadoradecalorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/food")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity addFoodList(@RequestBody List<Food> foods) {
        foodService.addFoodList(foods);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ingredientes agregados.");
    }
}
