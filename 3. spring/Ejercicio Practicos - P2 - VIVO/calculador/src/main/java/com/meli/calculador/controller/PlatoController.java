package com.meli.calculador.controller;

import com.meli.calculador.dtos.IngredienteDto;
import com.meli.calculador.dtos.PlatoDto;
import com.meli.calculador.entity.Ingredientes;
import com.meli.calculador.entity.Plato;
import com.meli.calculador.repository.CaloriesRespository;
import com.meli.calculador.service.CaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class PlatoController {
    @Autowired
    CaloriesService caloriesService;


    @GetMapping("/plato/{name}")
    public ResponseEntity<List<IngredienteDto>> getPlato(@PathVariable String name)
    {

        return ResponseEntity.ok(caloriesService.getPlato(name).getIngredientes().stream().map(x-> new IngredienteDto(x.getName(),x.getCalories())).collect(Collectors.toList()));
    }

    @GetMapping("/plato/mostCalories/{name}")
    public ResponseEntity<List<IngredienteDto>> getMostCalories(@PathVariable String name)
    {
        return ResponseEntity.ok(caloriesService.getMostCalories(name));
    }

    @GetMapping("/plato/totalCalories/{name}")
    public ResponseEntity<String> getTotalCalories(@PathVariable String name)
    {
        return ResponseEntity.ok("Total calorias:"+caloriesService.getCalories(name));
    }

    //@GetMapping("/platos/")
    //public ResponseEntity<List<PlatoDto>> getListaPlato(@RequestParam List<String> names)
    //{

    //}

}
