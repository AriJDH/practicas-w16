package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

@RestController
public class CalcularAnioController {
    @GetMapping("/{anio}/{mes}/{dia}")
    public String calcular(@PathVariable int anio, @PathVariable int mes, @PathVariable int dia) {
        long diff = ChronoUnit.YEARS.between(
                LocalDate.of( anio , mes , dia ) ,
                LocalDate.now( ZoneId.of( "America/Montreal" ) )
        );
        return "años " + diff;
    }
}