package com.bootcamp.EdadPersona;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service

public class EdadPersonaService {

    public String calcular(Integer dia, Integer mes, Integer anio){
        LocalDate cumple;
        LocalDate hoy;

        try {
            cumple = LocalDate.of(anio, mes, dia);
            hoy = LocalDate.now();
        } catch (DateTimeException e){
            return "Ingresa un valor valido";
        }

        Period diferencia = Period.between(cumple,hoy);
        return String.valueOf(diferencia.getYears());
    }
}
