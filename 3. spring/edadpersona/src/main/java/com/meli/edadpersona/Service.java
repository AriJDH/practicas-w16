package com.meli.edadpersona;


import java.time.LocalDate;
import java.time.Period;

@org.springframework.stereotype.Service
public class Service {


    public String calcularEdad(int dia, int mes, int anio){

        Period period = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());

        return "La edad de la persona es: " + period.getYears();
    }

}
