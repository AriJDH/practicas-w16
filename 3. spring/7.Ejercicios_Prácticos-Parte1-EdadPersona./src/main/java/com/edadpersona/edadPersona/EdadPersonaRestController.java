package com.edadpersona.edadPersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaRestController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String edad(@PathVariable int dia,
                       @PathVariable int mes,
                       @PathVariable int anio){
        Period aniosEdad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        String edadPersona = String.format("%d años", aniosEdad.getYears());

        return edadPersona;
    }
}
