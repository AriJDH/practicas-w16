package com.example.calculadora.controllers;

import com.example.calculadora.dtos.EdadDto;
import com.example.calculadora.dtos.FechaDto;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalcularEdadController {

    @GetMapping("/calcularGet")
    public ResponseEntity<EdadDto> calcularEdadG(@RequestParam Integer day,
                                                 @RequestParam Integer month,
                                                 @RequestParam Integer year) {

        LocalDate lcD = LocalDate.of(year, month, day);
        int years = Period.between(lcD,LocalDate.now()).getYears();
        EdadDto edc = new EdadDto(years);
        return new ResponseEntity<>(edc, HttpStatus.OK);
    }

    @PostMapping("/calcularPost")
    public ResponseEntity<EdadDto> calcularEdadP(@RequestBody FechaDto fecha) {

        LocalDate lcD = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
        int years = Period.between(lcD,LocalDate.now()).getYears();
        EdadDto edc = new EdadDto(years);
        return new ResponseEntity<>(edc, HttpStatus.OK);
    }
}
