package com.mercadolibre.bootcamp.edadPersona.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/{day}/{month}/{year}")
    public int getEdad(@PathVariable int day, @PathVariable int month , @PathVariable int year){
        LocalDate date = LocalDate.of(year,month,day);
        return Period.between(date, LocalDate.now()).getYears();
    }
}
