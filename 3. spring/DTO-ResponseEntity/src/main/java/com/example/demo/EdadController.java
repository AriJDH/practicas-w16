package com.example.demo;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//@Data  con esto le agrega toods los gets sets y mas metodos por default
//@AllArgsConstructor con esto le agrega todos los constructores
//@NoArgsConstructor con esto agrega el constructor sin parametros

@RestController
@RequestMapping("/edad")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anno}")
    public String fechaNacimiento(@PathVariable int dia, @PathVariable int mes, @PathVariable int anno) throws ParseException {

        LocalDate fecha = LocalDate.of(anno,mes,dia);
        Period periodo = Period.between(fecha, LocalDate.now());
        return ""+periodo.getYears();

        /*LocalDate hoy = LocalDate.now();
        LocalDate fnac = LocalDate.of(anio,mes,dia);
        return Period.between(fnac,hoy).toString();*/
    }
}
