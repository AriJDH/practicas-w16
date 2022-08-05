package com.bootcamp.ejerciciorestaurante.controller;

import com.bootcamp.ejerciciorestaurante.dto.RequestDto;
import com.bootcamp.ejerciciorestaurante.dto.ResponseDto;
import com.bootcamp.ejerciciorestaurante.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CalculadoraCalorias")
public class DishController {

    @Autowired
    IngredientService service;

    @PostMapping("/datos")
    public ResponseEntity<ResponseDto> getIngredient(@RequestBody RequestDto requestDto){
        return new ResponseEntity<>(service.returnResponse(requestDto), HttpStatus.OK);
    }


}
