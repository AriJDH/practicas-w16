package com.testEdad.testEdad;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("edad")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public String calcularEdadPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){

    }
}
