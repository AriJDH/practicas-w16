package com.example.calculoedad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/CalculoEdad")
public class Controller {
    @GetMapping("/{day}/{month}/{year}")
    public int calculoEdad(@PathVariable int day, @PathVariable int month, @PathVariable int year){
        LocalDate hoy = LocalDate.now();
        LocalDate fnac = LocalDate.of(year,month,day);
        return Period.between(fnac,hoy).getYears();
    }
}
