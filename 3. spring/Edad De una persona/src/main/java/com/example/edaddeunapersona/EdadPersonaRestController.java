package com.example.edaddeunapersona;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaRestController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int anio){

        String retorno;
        try{
            Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
            retorno = "Tienes "+edad.getYears()+" años, "+edad.getMonths()+" meses y "+edad.getDays()+" dias.";
        }catch(DateTimeException e){
            retorno = "";
        }
        return retorno;
    }
}
