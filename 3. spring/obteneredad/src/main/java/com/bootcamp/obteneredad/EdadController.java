package com.bootcamp.obteneredad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/{day}/{month}/{year}")
    public Integer calcularEdad(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year){
        Period edad = Period.between(LocalDate.of(year, month , day), LocalDate.now());

        return edad.getYears();
    }

}
