package com.bootcamp.aplicacionP1VIVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@RestController
public class AgeController {

    @GetMapping("{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate hoy = LocalDate.now();
        LocalDate fechaIngresada = LocalDate.of(anio,mes,dia);
        int edad = Period.between(fechaIngresada, hoy).getYears();
        return edad;
    }
}
