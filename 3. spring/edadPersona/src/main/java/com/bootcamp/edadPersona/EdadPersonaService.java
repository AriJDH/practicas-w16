package com.bootcamp.edadPersona;

import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class EdadPersonaService {

    public String calcularEdadPersona(Integer dia, Integer mes, Integer anio){
        LocalDate fecha;

        try{
            fecha = LocalDate.of(anio, mes, dia);
        } catch(DateTimeException e){
            return "Ingrese una fecha valida";
        }

        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fecha, fechaActual);
        return String.valueOf(periodo.getYears());
    }
}
