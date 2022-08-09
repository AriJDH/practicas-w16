package com.bootcamp.application.controller;


import com.bootcamp.application.model.NumeroRomano;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {
    @GetMapping("/numero-romano")
    public NumeroRomano numeroRomano(@RequestParam String number) {
        NumeroRomano numeroRomano = new NumeroRomano(Integer.parseInt(number));
        numeroRomano.transform();
        return numeroRomano;
    }
}
