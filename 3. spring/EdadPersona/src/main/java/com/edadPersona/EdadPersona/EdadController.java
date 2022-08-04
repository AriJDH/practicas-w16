package com.edadPersona.EdadPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @Autowired
    private ServiceEdad service;
    @GetMapping("/{dia}/{mes}/{anio}")
    public Integer edadDeunaPersona(@PathVariable Integer dia,
                                   @PathVariable Integer mes,
                                   @PathVariable Integer anio){

        return service.calcularEdad(dia, mes, anio);
    }
}
