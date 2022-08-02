package com.ndemaio.demo.controller;

import com.ndemaio.demo.model.RomanNumeralsConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanNumeralsController {

    private final RomanNumeralsConverter romanNumeralsConverter;

    @Autowired
    public RomanNumeralsController(RomanNumeralsConverter romanNumeralsConverter){
        this.romanNumeralsConverter = romanNumeralsConverter;
    }

    @GetMapping(path = "/{number}")
    public String convertToRomanNumeral(@PathVariable Integer number){
        return romanNumeralsConverter.convert(number);
    }

}
