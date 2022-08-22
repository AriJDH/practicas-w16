package com.meli.edadpersona.Service;

import java.time.LocalDate;
import java.time.Period;

public class EdadPersonaService {

    public Integer calcularEdad(int day, int month, int year) {
        LocalDate today = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(year,month,day);
        return Period.between(fechaNacimiento, today).getYears();
    }

}
