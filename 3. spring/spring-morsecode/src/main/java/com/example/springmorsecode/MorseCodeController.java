package com.example.springmorsecode;

import Classes.MorseCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * Ejercicio > Modulo 8: Spring > IntroduccionASpring-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class MorseCodeController {

    @GetMapping("/{morseCode}")
    public String translate(@PathVariable String morseCode){
        return MorseCode.translate(morseCode);
    }
}
