package com.morse.CodigoMorse.controller;

import com.morse.CodigoMorse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseRestController {


    @Autowired
    private MorseService morseService;

    @GetMapping("/{codigo}")
    public String morseTranslate(@PathVariable String codigo){
        return morseService.morseTraductor(codigo);
    }


}
