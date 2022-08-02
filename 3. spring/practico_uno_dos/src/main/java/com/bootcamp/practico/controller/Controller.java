package com.bootcamp.practico.controller;

import com.bootcamp.practico.service.MorseCodeService;
import com.bootcamp.practico.service.NumberConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private NumberConverterService numberConverterService;
    @Autowired
    private MorseCodeService morseCodeService;


    @GetMapping("convert-number/{number}")
    public String convertNumber(@PathVariable int number) {
        return numberConverterService.toRoman(number);

    }


    @GetMapping("convert-morse/{word}")
    public String convertToMorseCode(@PathVariable String word) {

        morseCodeService.loadMap();
        return morseCodeService.morseCodeConverter(word);

    }


    @GetMapping("convert-morse-to-word/{morse}")
    public String convertToMorseCodeToWord(@PathVariable String morse) {

        morseCodeService.loadMap();
        return morseCodeService.morseCodeConverterToWord(morse);

    }


}
