package com.tomas.codigomorse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraduccionRestController {

    @Autowired
    private ServiceTraduccionMorse serviceTraduccion;

    @GetMapping("/{codigo}")
    public String obtenerCodigo(@PathVariable String codigo) {

        return serviceTraduccion.realizarTraduccion(codigo);

    }

}
