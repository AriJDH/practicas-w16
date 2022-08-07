package com.example.calculadoracalorias.controller;

import com.example.calculadoracalorias.dto.CalorieDTO;
import com.example.calculadoracalorias.dto.IngredientDTO;
import com.example.calculadoracalorias.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculator-calories")
public class CalculatorController {


    private CalculatorService service;
    public CalculatorController(CalculatorService service){
        this.service = service;
    }

    @GetMapping("/amount-calories/{dish}")
    public ResponseEntity<CalorieDTO> getcaloriesDishes(@PathVariable String dish){
        return new ResponseEntity<>(service.getCalories(dish), HttpStatus.OK);
    }

    @GetMapping("/ingredients/{dish}")
    public ResponseEntity<List<IngredientDTO>> getDishIngredients(@PathVariable String dish){
        return new ResponseEntity<>(service.getDishIngredients(dish), HttpStatus.OK);
    }

    @GetMapping("/higher-calories/{dish}")
    public ResponseEntity<IngredientDTO> getMoreCaloricIngredient(@PathVariable String dish){
        return new ResponseEntity<>(service.getMoreCaloricIngredient(dish), HttpStatus.OK);
    }
}
