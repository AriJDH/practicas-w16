package com.CalculadoraCalorias.calorias.controllers;


import com.CalculadoraCalorias.calorias.DTO.IngredientesDTO;
import com.CalculadoraCalorias.calorias.services.caloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class caloriasRestController {
    @Autowired
    caloriasService serviceCalorias;

    @GetMapping("/{name}")
    public ResponseEntity<Integer> calcularCalorias(@PathVariable String name){
        return new ResponseEntity<>(serviceCalorias.calcularCalorias(name), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/{name}")
    public ResponseEntity<Map<String,Integer>> consultarIngredientes(@PathVariable String name){
        return new ResponseEntity<>(serviceCalorias.consultarIngredientes(name), HttpStatus.OK);
    }

    @GetMapping("/calorias/{name}")
    public ResponseEntity<Map.Entry<String,Integer>> consultarMayorCaloria(@PathVariable String name){
        return new ResponseEntity<>(serviceCalorias.consultarMayorCaloria(name), HttpStatus.OK);
    }
}
