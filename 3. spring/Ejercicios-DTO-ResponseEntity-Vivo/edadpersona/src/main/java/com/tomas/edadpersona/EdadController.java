package com.tomas.edadpersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){

        //Convierte los valores recibidos a fecha
        LocalDate fechaInicial = LocalDate.of(anio,mes,dia);
        LocalDate fechaActual = LocalDate.now();

        System.out.println(fechaActual);

        //Realiza la diferencia de fechas de la ingresada con respecto a la actual
        Period edad = Period.between(fechaInicial, fechaActual);

        return edad.getYears();
    }

}
