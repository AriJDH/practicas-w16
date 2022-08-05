package com.bootcamp.calculadoracalorias.controller;

import com.bootcamp.calculadoracalorias.dto.IngredienteDTO;
import com.bootcamp.calculadoracalorias.service.CalculadoraDeCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculadoraCaloriasController {
    @Autowired
    CalculadoraDeCaloriasService calculadoraDeCaloriasService;

    @GetMapping("/cantidadtotalcalorias/{name}/{peso}")
    public ResponseEntity<Double> cantidadCaloriasPlato(@PathVariable String name, @PathVariable double peso){
        return new ResponseEntity<>(calculadoraDeCaloriasService.cantidadCaloriasPlato(name, peso), HttpStatus.OK);
    }

    @GetMapping("/listaingredientes/{name}/{peso}")
    public ResponseEntity<List<IngredienteDTO>> ingredientesPlato(@PathVariable String name, @PathVariable double peso){
        return new ResponseEntity<>(calculadoraDeCaloriasService.ingredientesDelPlato(name, peso), HttpStatus.OK);
    }

    @GetMapping("/ingredientemayorcalorias/{name}/{peso}")
    public ResponseEntity<String> ingredienteMayorCalorias(@PathVariable String name, @PathVariable double peso){
        return new ResponseEntity<>(calculadoraDeCaloriasService.ingredienteMayorCalorias(name, peso), HttpStatus.OK);
    }
}
