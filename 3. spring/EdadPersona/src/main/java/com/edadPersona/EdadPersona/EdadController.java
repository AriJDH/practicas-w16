package com.edadPersona.EdadPersona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @Autowired
    private ServiceEdad service;

    @GetMapping("/{day}/{month}/{year}")
    public Integer edadDeunaPersona(@PathVariable Integer day,
                                   @PathVariable Integer month,
                                   @PathVariable Integer year){

        return service.calcularEdad(day, month, year);
    }
}

