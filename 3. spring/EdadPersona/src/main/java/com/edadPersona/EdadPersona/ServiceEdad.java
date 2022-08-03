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

    public Integer calcularEdad(Integer day, Integer month, Integer year){
        try {
            LocalDate birthDate = LocalDate.of(year, month, day);
            LocalDate currDate = LocalDate.now();

            return Period.between(birthDate, currDate).getYears();
        }catch (DateTimeException e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fecha con formato incorrecto");
        }
    }
}
