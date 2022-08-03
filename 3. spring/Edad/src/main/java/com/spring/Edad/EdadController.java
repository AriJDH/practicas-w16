package com.spring.Edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {
    @GetMapping("/{año}/{mes}/{dia}")
    public String calcularEdad(@PathVariable int año,@PathVariable int mes,@PathVariable int dia){
        Period edad = Period.between(LocalDate.of(año, mes, dia), LocalDate.now());

        return "Tienes "+edad.getYears()+" años "+edad.getMonths()+" meses y "+edad.getDays()+" dias";
    }
}
