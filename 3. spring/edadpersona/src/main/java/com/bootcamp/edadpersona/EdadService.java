package com.bootcamp.edadpersona;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadService {
    public String edadPersona(Integer dia, Integer mes, Integer anio){

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();

        int edad = Period.between(fechaNacimiento, fechaActual).getYears();

        return String.valueOf(edad);
    }
}
