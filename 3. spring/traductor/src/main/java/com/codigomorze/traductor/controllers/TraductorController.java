package com.codigomorze.traductor.controllers;


import com.codigomorze.traductor.services.TraductorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraductorController {

    @GetMapping("/decode/{codigoMorse}")
    public String traducirMorse(@PathVariable String codigoMorse){
        TraductorService traductorService = new TraductorService();
        return traductorService.descifrarMorse(codigoMorse);
    }
}
