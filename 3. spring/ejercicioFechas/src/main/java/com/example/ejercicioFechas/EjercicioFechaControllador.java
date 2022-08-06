package com.example.ejercicioFechas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EjercicioFechaControllador {

    EjercicioFechaService service = new EjercicioFechaService();

    @GetMapping(path="/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable int dia,
                          @PathVariable int mes,
                          @PathVariable int anio){


        return service.calcularEdad(dia,mes,anio);
    }
}
