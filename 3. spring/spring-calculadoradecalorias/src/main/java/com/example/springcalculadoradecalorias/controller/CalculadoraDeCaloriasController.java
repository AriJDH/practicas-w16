package com.example.springcalculadoradecalorias.controller;

import com.example.springcalculadoradecalorias.dto.RequestDTO;
import com.example.springcalculadoradecalorias.dto.ResponseDTO;
import com.example.springcalculadoradecalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 * Ejercicio > Modulo 8: Spring > EjerciciosPracticos-P2-VIVO
 * ESTADO: Pendiente.
 * @GonzaloNahuelDiPierro
 * */
@RestController
@RequestMapping("/calculadoradecalorias")
public class CalculadoraDeCaloriasController {
    @Autowired
    IngredienteService ingredienteService;

    @GetMapping("/datos")
    public ResponseEntity<ResponseDTO> calcular(@RequestBody RequestDTO requestDTO) {
        return new ResponseEntity<>(ingredienteService.calcularDatos(requestDTO), HttpStatus.OK);
    }
}
