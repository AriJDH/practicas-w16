package com.bootcamp.CalculadoraCalorias.controller;

import com.bootcamp.CalculadoraCalorias.dto.IngredienteDTO;
import com.bootcamp.CalculadoraCalorias.dto.PlatoDTO;
import com.bootcamp.CalculadoraCalorias.service.Servicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Controller {
    @Autowired
    private Servicio service;

    @GetMapping("/{plato}")
    public PlatoDTO mostrarPlato(@PathVariable String plato){
        return service.getPlatoDTO(plato);
    }

    @RequestMapping("/{valor1}/{valor2}/{valor3}")
    public List<PlatoDTO> arregloPlatos(@PathVariable String valor1, @PathVariable String valor2, @PathVariable String valor3){
        return service.getListaPlatosDTO(valor1, valor2, valor3);
    }

}
