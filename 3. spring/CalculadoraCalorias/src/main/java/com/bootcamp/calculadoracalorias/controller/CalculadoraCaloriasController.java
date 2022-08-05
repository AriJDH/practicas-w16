package com.bootcamp.calculadoracalorias.controller;

import com.bootcamp.calculadoracalorias.dto.DatosPlatoDto;
import com.bootcamp.calculadoracalorias.dto.IngredienteDTO;
import com.bootcamp.calculadoracalorias.service.CalculadoraDeCaloriasService;
import com.bootcamp.calculadoracalorias.service.ICalculadoraDeCaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CalculadoraCaloriasController {
    @Autowired
    ICalculadoraDeCaloriasService calculadoraDeCaloriasService;

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

    @GetMapping("/cantidadtotalcaloriasListaPlatos")
    public ResponseEntity<List<Double>> cantidadCaloriasListaDePLatos(@RequestBody List<DatosPlatoDto> datosPlato){
        return new ResponseEntity<>(calculadoraDeCaloriasService.cantidadCaloriasListaDePLatos(datosPlato),HttpStatus.OK);
    }

    @GetMapping("/listarIngredientesDeListaPlatos")
    public ResponseEntity<List<List<IngredienteDTO>>> ingredientesPlato(@RequestBody List<DatosPlatoDto> datosPlato){
        return new ResponseEntity<>(calculadoraDeCaloriasService.ingredientesDeListaDePlatos(datosPlato), HttpStatus.OK);
    }

    @GetMapping("/ingredientemayorcaloriasListaPlatos")
    public ResponseEntity<List<String>> ingredienteMayorCaloriasListaPlatos(@RequestBody List<DatosPlatoDto> datosPlato){
        return new ResponseEntity<>(calculadoraDeCaloriasService.ingredienteMayorCaloriasListaPlatos(datosPlato), HttpStatus.OK);
    }
}
