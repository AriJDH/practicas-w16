package com.P2PG.P2PG;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumRomanos {

    @GetMapping("/{number}")
    public String numRomano(@PathVariable Integer number)
    {
        FuncionNumRomanos numero = new FuncionNumRomanos(number);
        String numeroRomano = numero.convertirANumerosRomanos(number);
        return "Numero romano " + numeroRomano;
    }


}
