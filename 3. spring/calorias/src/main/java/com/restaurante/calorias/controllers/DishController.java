package com.restaurante.calorias.controllers;

import com.restaurante.calorias.dto.DishDTO;
import com.restaurante.calorias.dto.DishResponseDTO;
import com.restaurante.calorias.dto.IngredientDTO;
import com.restaurante.calorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/dish/calories")
    public ResponseEntity<DishResponseDTO> getCalories(@RequestBody DishDTO dish){
        return new ResponseEntity<>(dishService.getCalories(dish), HttpStatus.OK);
    }
    @GetMapping("/alldishes/calories")
    public ResponseEntity<List<DishResponseDTO>> getAllCalories(@RequestBody List<DishDTO> dishes){
        return new ResponseEntity<>(dishService.getAllCalories(dishes), HttpStatus.OK);
    }

    @GetMapping("/ingredient/calories")
    public ResponseEntity<IngredientDTO> getIngredientCalories(){
        return new ResponseEntity<>(dishService.getIngredientsCalories(), HttpStatus.OK);
    }

}
