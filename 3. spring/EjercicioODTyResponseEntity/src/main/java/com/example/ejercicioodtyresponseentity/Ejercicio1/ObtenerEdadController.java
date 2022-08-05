package com.example.ejercicioodtyresponseentity.Ejercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class ObtenerEdadController {
    @GetMapping(path = "/{dia}/{mes}/{anio}")
    public Integer obtenerEdad(@PathVariable Integer dia,@PathVariable Integer mes,@PathVariable Integer anio){

        LocalDate fechaHoy = LocalDate.now();

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        Period periodo = Period.between(fechaNacimiento, fechaHoy);

        return periodo.getYears();
    }

}
