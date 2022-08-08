package com.ejemplo.edades;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadesController {

    @GetMapping("/{dia}/{mes}/{ano}")
    public String obtenerfecha(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {

        LocalDate fechaInicial = LocalDate.of(ano,mes,dia);
        LocalDate fechaFinal = LocalDate.now();

        Period prueba = Period.between(fechaInicial, fechaFinal) ;

        return "Su edad es: " + prueba.getYears() + " años";

    }

}
