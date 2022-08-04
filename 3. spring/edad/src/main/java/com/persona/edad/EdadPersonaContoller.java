package com.persona.edad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class EdadPersonaContoller {

    @GetMapping("{dia}/{mes}/{ano}")
    public Integer getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano) {
        Period edad = Period.between(LocalDate.of(ano, mes, dia), LocalDate.now());
        return edad.getYears();
    }
}
