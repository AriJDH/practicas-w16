package com.spring.ejercicioEdad;

import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalcularEdadController {

    @RequestMapping("/calcularEdad/{dia}/{mes}/{anio}")
    public int calcularEdadDePersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        return edad.getYears();

    }
}
