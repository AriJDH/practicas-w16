package com.bootcamp.romanosejercicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {

    RomanosService romanosService = new RomanosService();

    @GetMapping("{number}")
    public String decimalToRoman(@PathVariable Integer number){
        return romanosService.coverteDecimalToRoman(number);
    }
}
