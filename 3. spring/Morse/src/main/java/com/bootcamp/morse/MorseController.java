package com.bootcamp.morse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    MorseService morseService = new MorseService();

    @GetMapping("{morse}")
    public String morseToSpanish(@PathVariable String morse){
        return morseService.morseToSpanish(morse);
    }
}
