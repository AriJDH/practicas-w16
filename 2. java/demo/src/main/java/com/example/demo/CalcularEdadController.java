package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;

@RestController
public class CalcularEdadController {


    @GetMapping("/calcular/{dia}/{mes}/{ano}")
    public int  calcularEdad (@PathVariable int dia,
                             @PathVariable int mes,
                             @PathVariable int ano)
    {


      LocalDate fecha = LocalDate.of(ano,mes,dia);

        Period period = Period.between(fecha,LocalDate.now());


     return period.getYears();
    }

}
