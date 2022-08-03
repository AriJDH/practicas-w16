package com.bootcamp.aplicacion.service;

import ch.qos.logback.core.rolling.helper.PeriodicityType;

import java.time.LocalDate;
import java.time.Period;

public class service {
        public Integer calcularEdad(String diaNacimiento){

            String vueltaAlSol[] = diaNacimiento.split("-");
            LocalDate cumpleanios = LocalDate.of(Integer.parseInt(vueltaAlSol[2]), Integer.parseInt(vueltaAlSol[1]), Integer.parseInt(vueltaAlSol[0]));

            Period period = Period.between(cumpleanios, LocalDate.now());

            return period.getYears();
    }
}
