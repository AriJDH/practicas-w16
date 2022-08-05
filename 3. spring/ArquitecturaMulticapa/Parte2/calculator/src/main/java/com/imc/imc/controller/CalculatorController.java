package com.imc.imc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.imc.imc.dto.Dish;
import com.imc.imc.dto.DishesDTO;
import com.imc.imc.dto.MultipleDishesResponse;
import com.imc.imc.dto.CalculatorResponseDTO;
import com.imc.imc.service.CalculatorService;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService imcService;

    @PostMapping("/dish/calculator")
    public ResponseEntity<CalculatorResponseDTO> dishCalculator(@RequestBody Dish dishRequest){
        return new ResponseEntity<>(imcService.dishCalculator(dishRequest), HttpStatus.OK);
    }

    @PostMapping("/dishes/calculator")
    public ResponseEntity<MultipleDishesResponse> dishesCalculator(@RequestBody DishesDTO dishesRequest){
        return new ResponseEntity<>(imcService.dishesCalculator(dishesRequest), HttpStatus.OK);
    }


}
