package com.bootcamp.EdadPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController

public class EdadaPersonaController {
    @Autowired
    private  EdadPersonaService servicio;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcular(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return servicio.calcular(dia,mes,anio);
    }
}
