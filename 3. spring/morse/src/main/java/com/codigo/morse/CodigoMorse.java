package com.codigo.morse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    @Autowired
    private Services service;

    @GetMapping("/{codigo}")
    public String DevolverFrase(@PathVariable String codigo){
         String resultado = service.decodificarMorse(codigo);
         return resultado;
    }
}
