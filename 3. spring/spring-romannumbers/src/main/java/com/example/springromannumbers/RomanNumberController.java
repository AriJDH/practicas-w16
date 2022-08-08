package com.example.springromannumbers;

import Classes.RomanNumber;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * Ejercicio > Modulo 8: Spring > IntroduccionASpring-P2-PG
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
@RestController
public class RomanNumberController {

    @GetMapping("/{number}")
    public String getRomanNumber(@PathVariable int number){
        return RomanNumber.get(number);
    }
}
