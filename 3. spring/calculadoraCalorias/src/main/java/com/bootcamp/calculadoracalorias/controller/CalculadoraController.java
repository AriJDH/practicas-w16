package com.bootcamp.calculadoracalorias.controller;

import com.bootcamp.calculadoracalorias.dto.CaloriaDTO;
import com.bootcamp.calculadoracalorias.dto.IngredienteDTO;
import com.bootcamp.calculadoracalorias.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculadora-calorias")
public class CalculadoraController {

  @Autowired
  private CalculadoraService service;

  @GetMapping("/cantidad-calorias/{plato}")
  public ResponseEntity<CaloriaDTO> obtenerCaloriasPlato(@PathVariable String plato) {
    return new ResponseEntity<>(service.obtenerCalorias(plato), HttpStatus.OK);
  }

  @GetMapping("/ingredientes/{plato}")
  public ResponseEntity<List<IngredienteDTO>> obtenerIngredientesPlato(@PathVariable String plato) {
    return new ResponseEntity<>(service.obtenerIngredientesPlato(plato), HttpStatus.OK);
  }

  @GetMapping("/mayorCalorias/{plato}")
  public ResponseEntity<IngredienteDTO> obtenerIngredienteMasCalorico(@PathVariable String plato) {
    return new ResponseEntity<>(service.obtenerIngredienteMasCalorico(plato), HttpStatus.OK);
  }
}