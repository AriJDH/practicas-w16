package com.javaW16.calculadoraCalorias.controller;

import java.util.List;
import com.javaW16.calculadoraCalorias.dto.IngredienteDTO;
import com.javaW16.calculadoraCalorias.dto.PlatoDTO;
import com.javaW16.calculadoraCalorias.dto.ResponseDTO;
import com.javaW16.calculadoraCalorias.services.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

   @Autowired
   Services services;

   @PostMapping("/createIngredientesList")
   public ResponseEntity<ResponseDTO> createIngredientesListController(@RequestBody List<IngredienteDTO> ingredientesDTO) {
      return new ResponseEntity<>(services.createIngredientesListService(ingredientesDTO), HttpStatus.OK);
   }

   @GetMapping("/getAllIngredientes")
   public ResponseEntity<List<IngredienteDTO>> getAllIngredientes(){
      return new ResponseEntity<>(services.getAllIngredientes(),HttpStatus.OK);
   }

   @PostMapping("/createPlato")
   public void createPlato(@RequestBody PlatoDTO platoDTO){
      services.createPlatosListService(platoDTO);
   }

   @GetMapping("/getAllPlato")
   public ResponseEntity<List<PlatoDTO>> getAllPlatos(){
      return new ResponseEntity<>(services.getAllPlatos(),HttpStatus.OK);
   }

}
