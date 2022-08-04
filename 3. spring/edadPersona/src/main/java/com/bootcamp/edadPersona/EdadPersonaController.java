package com.bootcamp.edadPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@RestController
public class EdadPersonaController {
    private final EdadPersonaService edadPersonaService;

    public EdadPersonaController(EdadPersonaService edadPersonaService) {
        this.edadPersonaService = edadPersonaService;
    }

    @GetMapping("{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        return edadPersonaService.calcularEdadPersona(dia, mes, anio);

    }
}
