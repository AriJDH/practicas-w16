package com.codigoMorse.codigoMorse;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class CalculadoraDeEdadController {
    @GetMapping("/{dia}/{mes}/{año}")
    public Integer calcularFecha(@PathVariable Integer dia,
                                @PathVariable Integer mes,
                                @PathVariable Integer año){
    Period edad = Period.between(LocalDate.of(año, mes, dia), LocalDate.now());
    return edad.getYears();

    }

}
