package com.spring.calculadora_de_calorias.controller;

import com.spring.calculadora_de_calorias.DTO.IngredienteDTO;
import com.spring.calculadora_de_calorias.service.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComidaController {

    @Autowired
    PlatoServiceImpl platoService;

    @GetMapping("/{name}")
    public ResponseEntity<Integer> getCaloriasPlato(@PathVariable String name){
        return new ResponseEntity<>(platoService.getCaloriasPlato(name), HttpStatus.OK);
    }

    @GetMapping("/ing/{name}")
    public ResponseEntity<List<IngredienteDTO>> getIngredientesPlato(@PathVariable String name){
        return new ResponseEntity<>(platoService.getIngredientesPlato(name), HttpStatus.OK);
    }

    @GetMapping("/mayorCal/{name}")
    public ResponseEntity<IngredienteDTO> getIngMayorCal(@PathVariable String name){
        return new ResponseEntity<>(platoService.mayorCalorias(name), HttpStatus.OK);
    }

}
