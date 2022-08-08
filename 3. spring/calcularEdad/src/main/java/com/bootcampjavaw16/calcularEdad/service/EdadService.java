package com.bootcampjavaw16.calcularEdad.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadService {

    public Integer calcularEdad(Integer dia, Integer mes, Integer anio) {
        /*String fecha = dia+"/"+mes+"/"+anio;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fecha, dateTimeFormatter);
        LocalDate presente = LocalDate.now();

        Period period = Period.between(fechaNacimiento, presente);
        */
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        return edad.getYears();
    }
}
