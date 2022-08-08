package com.bootcampjavaw16.calcularEdad.controller;

import com.bootcampjavaw16.calcularEdad.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class edadController {

    @Autowired
    EdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        return ("Su edad es de: " + edadService.calcularEdad(dia, mes, anio) + " años");
    }
}
