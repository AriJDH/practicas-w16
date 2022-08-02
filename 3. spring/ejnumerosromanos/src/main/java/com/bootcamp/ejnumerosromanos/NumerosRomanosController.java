package com.bootcamp.ejnumerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping("/{numeroString}")
    public String numeroRomano(@PathVariable String numeroString){
        int numero = Integer.parseInt(numeroString);
        String unidad[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String decena[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String centena[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

        int mil = numero /1000;
        int res = numero % 1000;

        int cen = res / 100;
        res = res % 100;

        int dec = res / 10;
        int un = res % 10;

        String miles= "";
        for(int i = 1;i<=mil;i++){
            miles+="M";
        }
        String retorno = "";
        if(mil>0){
            retorno = miles+centena[cen]+decena[dec]+unidad[un];
        }else if (cen >0){
            retorno = centena[cen]+decena[dec]+unidad[un];
        }else if(dec>0){
            retorno = decena[dec]+unidad[un];
        }else {retorno = unidad[un];}
        return retorno;
    }
}
