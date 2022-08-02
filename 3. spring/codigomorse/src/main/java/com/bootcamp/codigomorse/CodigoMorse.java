package com.bootcamp.codigomorse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorse {

    @Autowired
    private ServiceCodigoMorse service;

    @GetMapping("/{codigoMorse}")
    public String devolverFrase(@PathVariable String codigoMorse) {
        return service.convertirFrase(codigoMorse);
    }
}
