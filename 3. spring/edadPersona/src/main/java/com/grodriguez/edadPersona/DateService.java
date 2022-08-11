package com.grodriguez.edadPersona;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;
import static java.util.Calendar.DATE;

public class DateService {

    public DateService() {
    }

    public static int getDiff(int dia, int mes, int anio){

        int edad = 0;
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fecha = LocalDate.of(anio, mes, dia);

        edad = Period.between(fecha, fechaHoy).getYears();

        return edad;
    }
}
