package com.fechadecumpleanios.app.services;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class EdadService {

    public Integer calcularEdad(String dia,String mes, String anio) throws ParseException {
        String fechaString = dia+"/"+mes+"/"+anio;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaString, formato);
        LocalDate ahora = LocalDate.now();

        Period period = Period.between(fechaNac, ahora);

        return period.getYears();

    }
}
