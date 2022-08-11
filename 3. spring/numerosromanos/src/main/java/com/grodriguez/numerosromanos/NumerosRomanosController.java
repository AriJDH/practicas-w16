package com.grodriguez.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping
    public String home(){
        return "Hola!";
    }

    @GetMapping("/{num}") // este num y la variable de abajo se tienen que llamar igual
    public String getNumero(@PathVariable int num){

        String ret = "No data";

        switch(num){
            case 1:
                ret = "I";
                break;
            case 2:
                ret = "II";
                break;
            case 3:
                ret = "II";
                break;
            case 4:
                ret = "IV";
                break;
            case 5:
                ret = "V";
                break;
            case 6:
                ret = "VI";
                break;
            case 7:
                ret = "VII";
                break;
            case 10:
                ret = "X";
                break;
            case 13:
                ret = "XIII";
                break;
            case 50:
                ret = "L";
                break;
            case 100:
                ret = "C";
                break;
            case 500:
                ret = "D";
                break;
            case 1000:
                ret = "M";
                break;
            default:
                break;
        }

        return ret;
    }
}
