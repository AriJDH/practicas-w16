package com.romannumerals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    NumerosRomanosService service;

    public NumerosRomanosController(NumerosRomanosService service) {
        this.service = service;
    }

    @GetMapping("/{value}")
    public String numeroRomano(@PathVariable Integer value){
        return service.changeToRoman(value);
    }
}
