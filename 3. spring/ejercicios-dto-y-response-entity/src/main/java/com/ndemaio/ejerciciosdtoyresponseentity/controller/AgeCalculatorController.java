package com.ndemaio.ejerciciosdtoyresponseentity.controller;

import com.ndemaio.ejerciciosdtoyresponseentity.model.AgeCalculator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class AgeCalculatorController {

    @GetMapping (path = "/{day}/{month}/{year}")
    public Long calculateAgeFrom(@PathVariable Integer day, @PathVariable Integer month, @PathVariable Integer year) {
        return new AgeCalculator().calculateFrom(LocalDate.of(year, month, day));
    }

}
