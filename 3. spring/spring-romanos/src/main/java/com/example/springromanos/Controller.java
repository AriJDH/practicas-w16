package com.example.springromanos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ServiceRomanos service;

    @GetMapping("/{numero}")
    public String numeroRomano(@PathVariable Integer numero){
        return this.service.numeroRomano(numero);
    }

}
