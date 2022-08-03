package com.bootcamp.aplicacion.controller;

import com.bootcamp.aplicacion.service.service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class controller {

        @GetMapping("/{fechaIngresada}" )
        public Integer calcular(@PathVariable String fechaIngresada){
            service s = new service();

            return s.calcularEdad(fechaIngresada);
        }


}
