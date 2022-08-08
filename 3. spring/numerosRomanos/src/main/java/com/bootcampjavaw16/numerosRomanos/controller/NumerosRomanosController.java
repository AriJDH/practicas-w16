package com.bootcampjavaw16.numerosRomanos.controller;

import com.bootcampjavaw16.numerosRomanos.service.NumeroRomanoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/romanos")
public class NumerosRomanosController {

    final
    NumeroRomanoService numeroRomanoService;

    public NumerosRomanosController(NumeroRomanoService numeroRomanoService) {
        this.numeroRomanoService = numeroRomanoService;
    }

    @GetMapping("/{numero}")
    public ResponseEntity<String> convertirARomano(@PathVariable Integer numero) {

        String result = numeroRomanoService.romanize(numero);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
