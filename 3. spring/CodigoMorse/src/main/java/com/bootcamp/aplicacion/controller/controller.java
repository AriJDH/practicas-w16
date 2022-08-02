package com.bootcamp.aplicacion.controller;

import com.bootcamp.aplicacion.service.service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
@RequestMapping("/codigoMorse")
public class controller {

    @GetMapping("/{textoOriginal}" )
    public String texto(@PathVariable String textoOriginal){
        service s = new service();

        return s.decodificarMorse(textoOriginal);
    }


}
