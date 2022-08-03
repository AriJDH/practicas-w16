package com.fechadecumpleanios.app.controller;

import com.fechadecumpleanios.app.services.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/api/edad")
public class EdadController {

    @Autowired
    private EdadService edadService;

    @GetMapping("/obtener")
    private Integer obtenerEdad(@RequestParam String dia,@RequestParam String mes, @RequestParam String anio) throws ParseException {
        return edadService.calcularEdad(dia,mes,anio);
    }
}
