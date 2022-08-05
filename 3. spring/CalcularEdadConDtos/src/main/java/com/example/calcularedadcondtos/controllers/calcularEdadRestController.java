package com.example.calcularedadcondtos.controllers;

import com.example.calcularedadcondtos.dtos.EdadDto;
import com.example.calcularedadcondtos.dtos.FechaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class calcularEdadRestController {

    @GetMapping("/calcularGet")
    public ResponseEntity<EdadDto> calcularEdadG(@RequestParam Integer day,@RequestParam Integer month,@RequestParam Integer year) {
        LocalDate lcD = LocalDate.of(year, month, day);
        int period = Period.between(lcD, LocalDate.now()).getYears();
        EdadDto edc = new EdadDto(period);

        return new ResponseEntity<>(edc, HttpStatus.OK);
    }

    @PostMapping("/CalcularPost")
    public ResponseEntity<EdadDto> CalcularEdadP(@RequestBody FechaDto fecha){
        LocalDate lcD = LocalDate.of(fecha.getAnio(), fecha.getMes(), fecha.getDia());
        int period = Period.between(lcD, LocalDate.now()).getYears();
        EdadDto edc = new EdadDto(period);

        return new ResponseEntity<>(edc, HttpStatus.OK);
    }
}
