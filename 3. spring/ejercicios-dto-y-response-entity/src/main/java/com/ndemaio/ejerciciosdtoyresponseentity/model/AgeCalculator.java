package com.ndemaio.ejerciciosdtoyresponseentity.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class AgeCalculator {
    public Long calculateFrom(LocalDate aDate) {
        return ChronoUnit.YEARS.between(aDate, today());
    }

    private Temporal today() {
        return LocalDate.now();
    }
}
