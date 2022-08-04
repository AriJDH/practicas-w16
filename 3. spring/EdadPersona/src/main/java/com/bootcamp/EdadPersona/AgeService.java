package com.bootcamp.EdadPersona;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeService {

    public Integer age(Integer dia, Integer mes, Integer ano){

        Period edad = Period.between(LocalDate.of(ano, mes, dia), LocalDate.now());
        return edad.getYears();
    }

}
