package com.bootcamp.edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public Integer calcularFecha(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());

        return edad.getYears();
    }
}
