package com.myapp.edad.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class EdadService {
    public String calcularEdadA(String dia, String mes, String anio){
        DateTimeFormatter formato_fecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fecha_auxiliar = dia+"/"+mes+"/"+anio;
        LocalDate fecha_nacimiento = LocalDate.parse(fecha_auxiliar, formato_fecha);

        LocalDate fecha_hoy = LocalDate.now();

        Period edad = fecha_nacimiento.until(fecha_hoy);

        return String.valueOf("Tu edad es: " + edad.getYears());
    }
    public int calcularEdadB(int dia, int mes, int anio){
        Period edad = Period.between(LocalDate.of(anio, mes, dia), LocalDate.now());
        return edad.getYears();
    }
}
