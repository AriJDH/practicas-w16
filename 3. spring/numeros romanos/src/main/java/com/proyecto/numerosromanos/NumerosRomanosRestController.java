package com.proyecto.numerosromanos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosRestController {
    @Autowired
    private NumerosRomanosService serviceApi;

    @GetMapping("/numero/{numero}")
    public String getNumeroRomano(@PathVariable Integer numero) {
        return serviceApi.getNumeroRomano(numero);
    }
}
