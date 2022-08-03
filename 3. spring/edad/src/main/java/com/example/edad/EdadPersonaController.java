package com.example.edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("")
public class EdadPersonaController {
    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {
        //recibo las variables por parametro
        LocalDate localDate = LocalDate.parse(anio + "-" + mes + "-" + dia);
        //busco entre las fechas
        Period period = Period.between(localDate, LocalDate.now());
        String anios = String.valueOf(period.getYears());
        return anios;
    }
}