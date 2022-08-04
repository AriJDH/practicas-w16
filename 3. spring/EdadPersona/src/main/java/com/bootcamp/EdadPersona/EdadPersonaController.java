package com.bootcamp.EdadPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EdadPersonaController {

    @Autowired
    private AgeService servicio;

    @GetMapping("calculate/{dia}/{mes}/{ano}")
    public String calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer ano){

        return String.valueOf(servicio.age(dia,mes,ano));

    }

}
