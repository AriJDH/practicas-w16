package com.meli.numerosromanos.Controller;

import com.meli.numerosromanos.Service.NumerosRomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NumerosRomanos")
public class NumerosRomanosController {

    @GetMapping(path = "/{numero}")
    public String numerosRomanos(@PathVariable int numero) {
        NumerosRomanosService numerosRomanosService = new NumerosRomanosService();
        return numerosRomanosService.numerosRomanos(numero);
    }
}
