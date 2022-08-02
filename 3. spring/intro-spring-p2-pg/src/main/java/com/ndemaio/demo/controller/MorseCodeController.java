package com.ndemaio.demo.controller;

import com.ndemaio.demo.model.MorseCodeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseCodeController {

    private final MorseCodeConverter morseCodeConverter;

    @Autowired
    public MorseCodeController(MorseCodeConverter morseCodeConverter) {
        this.morseCodeConverter = morseCodeConverter;
    }

    @GetMapping(path = "morse/{code}")
    public String converToWords(@PathVariable String code){
        return morseCodeConverter.convert(code);
    }
}



