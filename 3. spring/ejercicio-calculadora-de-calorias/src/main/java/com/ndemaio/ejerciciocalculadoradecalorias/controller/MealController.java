package com.ndemaio.ejerciciocalculadoradecalorias.controller;

import com.ndemaio.ejerciciocalculadoradecalorias.dto.MealDataRequest;
import com.ndemaio.ejerciciocalculadoradecalorias.entity.Meal;
import com.ndemaio.ejerciciocalculadoradecalorias.service.MealNotFoundException;
import com.ndemaio.ejerciciocalculadoradecalorias.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/meal")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public ResponseEntity addMeal(@RequestBody Meal meal){
        mealService.addMeal(meal);
        return ResponseEntity.status(HttpStatus.CREATED).body("Plato agregado");
    }

    @GetMapping
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok().body(mealService.getMeals());
    }

    @GetMapping(path = "/multiple")
    public ResponseEntity getMealsByName(@RequestBody List<MealDataRequest> mealDataRequests) throws MealNotFoundException {
        return ResponseEntity.ok(mealService.getInformationFor(mealDataRequests));
    }

    @GetMapping(path = "/single")
    public ResponseEntity getMealByName(@RequestBody MealDataRequest mealDataRequest) throws MealNotFoundException {
        return ResponseEntity.ok(mealService.getMealNamed(mealDataRequest.getName(), mealDataRequest.getWeight()));
    }

}
