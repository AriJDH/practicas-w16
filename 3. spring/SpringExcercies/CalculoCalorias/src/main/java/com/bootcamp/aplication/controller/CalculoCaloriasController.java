package com.bootcamp.aplication.controller;

import com.bootcamp.aplication.dto.OrderDTO;
import com.bootcamp.aplication.dto.ResponseDTO;
import com.bootcamp.aplication.service.CalculoCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculoCaloriasController {

    @Autowired
    CalculoCaloriasService caloriasService;

    @GetMapping("/allfood")
    public ResponseEntity getAllFood() {

        return ResponseEntity.ok()
                .body(caloriasService.findAllFood());
    }

    @GetMapping("/caloriesdata")
    public ResponseEntity<List<ResponseDTO>> calduloCalorias(@RequestBody List<OrderDTO> pedido) {

        return ResponseEntity.ok()
                .body(caloriasService.caloriesCalculate(pedido));
    }


}
