package com.bootcamp.NumerosRomanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    @GetMapping("/romano/{numero}")
    public String Conversion(@PathVariable int numero){

        ConvertirRomano ConvertirRomano = new ConvertirRomano();

        return ConvertirRomano.ConversionARomano(numero);

    }


}
