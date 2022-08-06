package com.example.ejercicioFechas;

import java.time.LocalDate;
import java.time.Period;

public class EjercicioFechaService {

    public String calcularEdad (int dia,int mes, int anio){
        Period period = Period.between(LocalDate.of(anio,mes,dia),LocalDate.now());

        return "La edad actual es: "+period.getYears();
    }
}
