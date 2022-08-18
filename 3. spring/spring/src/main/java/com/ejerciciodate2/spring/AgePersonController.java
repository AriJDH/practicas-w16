package com.ejerciciodate2.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class AgePersonController {
    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer getPersonAge(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano) {
        LocalDate fecha = LocalDate.of(ano,mes, dia);
        LocalDate ahora = LocalDate.now();
        Period diff = Period.between(fecha, ahora);
        return diff.getYears();
    }
}
