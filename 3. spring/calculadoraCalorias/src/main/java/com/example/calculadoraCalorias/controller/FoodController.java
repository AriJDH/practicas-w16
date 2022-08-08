package com.example.calculadoraCalorias.controller;

import com.example.calculadoraCalorias.dtos.PlatoDTO;
import com.example.calculadoraCalorias.dtos.RequestFoodDTO;
import com.example.calculadoraCalorias.entities.Plato;
import com.example.calculadoraCalorias.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    FoodService servicio;

    @GetMapping("/food/{plato}/{gramos}")
    public ResponseEntity<PlatoDTO> findPlate(@PathVariable String plato, @PathVariable Integer gramos){
        PlatoDTO dto = servicio.findPlato(plato,gramos);

        if(dto!=null)
            return new ResponseEntity<>(dto, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/food")
    public ResponseEntity<List<PlatoDTO>> gelPlatoList(@RequestBody List<RequestFoodDTO> listaDePlatosRecibida){

        return new ResponseEntity<>(servicio.findPlato(listaDePlatosRecibida), HttpStatus.OK);
    }


}
