package com.example.springcalculadoradecalorias.controller;

import com.example.springcalculadoradecalorias.dto.PlatoDTO;
import com.example.springcalculadoradecalorias.dto.InformacionPlatoDTO;
import com.example.springcalculadoradecalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Ejercicio > Modulo 8: Spring > EjerciciosPracticos-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
@RequestMapping("/calculadoradecalorias")
public class CalculadoraDeCaloriasController {
    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/plato")
    public ResponseEntity<InformacionPlatoDTO> getData(@RequestBody PlatoDTO platoDTO) {
        return new ResponseEntity<>(ingredienteService.getInformacion(platoDTO), HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<List<InformacionPlatoDTO>> getData(@RequestBody List<PlatoDTO> platoDTOList) {
        return new ResponseEntity<>(ingredienteService.getInformacion(platoDTOList), HttpStatus.OK);
    }
}
