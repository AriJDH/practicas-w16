package com.example.edadpersona;

import java.time.LocalDate;
import java.time.Period;

public class EdadPersonaSerivce {

    public String calcularEdad(int dia, int mes, int anio){

        Period period = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());

        return "La edad de la persona es: " + period.getYears();
    }
}
