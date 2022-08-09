package com.edadPersona.EdadPersona;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.server.ResponseStatusException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@Service
public class ServiceEdad {
    private int edad;

    public Integer calcularEdad(Integer dia, Integer mes, Integer anio){

        try {
            LocalDate edadNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            Period period = Period.between(edadNacimiento, fechaActual);
            return period.getYears();
        }catch (DateTimeException e){
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Fecha con formato incorrecto", e);
        }

    }
}
