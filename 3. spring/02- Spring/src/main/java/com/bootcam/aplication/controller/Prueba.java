package com.bootcam.aplication.controller;

import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

@RestController
@RequestMapping("/prueba")
public class Prueba {

    @GetMapping("/{message}")
    public String message(@PathVariable String prueba)
    {
        return prueba;
    }
    @GetMapping("/{dia}/{mes}/{anno}")
    public String fechaNacimiento(@PathVariable int dia, @PathVariable int mes, @PathVariable int anno) throws ParseException {

        LocalDate fecha = LocalDate.of(anno,mes,dia);
        Period periodo = Period.between(fecha, LocalDate.now());
        return ""+periodo.getYears();
    }
}
