package com.calculadora.calorias.controller;

import com.calculadora.calorias.dto.FoodMenuDTO;
import com.calculadora.calorias.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RestaurantController {
    @Autowired
    IRestaurantService restaurantService;

    @GetMapping("/menu")
    public ResponseEntity<FoodMenuDTO> findMenuByName(@RequestParam String name, @RequestParam Double weight){
        return new ResponseEntity<>(restaurantService.findByName(name, weight), HttpStatus.OK);
    }
}
