package com.example.springedadpersona;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

/*
 * Ejercicio > Modulo 8: Spring > EjerciciosDTOYResponseEntity-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class PersonController {

    @GetMapping("edadpersona/forma1/{dia}/{mes}/{anio}")
    public int getAgeFormOne(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        return Period.between(fechaNacimiento, fechaHoy).getYears();
    }

    @GetMapping("/edadpersona/forma2/")
    public int getAgeFormTwo(@RequestParam int dia, @RequestParam int mes, @RequestParam int anio){
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);

        return Period.between(fechaNacimiento, fechaHoy).getYears();
    }
}
