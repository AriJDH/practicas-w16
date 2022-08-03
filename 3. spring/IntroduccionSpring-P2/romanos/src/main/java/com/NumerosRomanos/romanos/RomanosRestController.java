/*
    Autor: Tannia Lucía Hernández Rojas
    Conversión de numeros deciamales de 1 a 1000
*/

package com.NumerosRomanos.romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class RomanosRestController {

    @GetMapping("romanos/{decimal}")

    public String convertirARomano(@PathVariable int decimal){

        String romano = representacion(decimal);

        if (romano == "G"){
            romano = "";
            List<Integer> numeros = new ArrayList<>();

            while (decimal > 0) {
                numeros.add(decimal % 10);
                decimal = decimal / 10;
            }
            Collections.reverse(numeros);

            if (numeros.size() == 3){
                int num = (int) Math.round(numeros.get(0) * Math.pow(10, 2));
                romano += representacion(num);
                numeros.remove(0);
            }
            int ceros = numeros.size() - 1;
            for (int i = 0; i < numeros.size(); i++) {
                if (numeros.get(i) == 0 && i != numeros.size() - 1) {
                    ceros = ceros / 10;
                    continue;
                } else if (numeros.get(numeros.size() - 1) == 0) {
                    String numCadena = String.valueOf(numeros.get(0))+numeros.get(1);
                    romano += representacion(Integer.parseInt(  numCadena));
                    break;
                }
                else {
                    int num = (int) Math.round(numeros.get(i) * Math.pow(10, ceros));
                    romano += representacion(num);
                    ceros = ceros / 10;
                }
            }

        }

        return romano;
    }

    public String representacion(int numero){

        String numeroR = "";

        switch (numero) {

            case 1:
                numeroR = "I";
                break;
            case 2:
                numeroR = "II";
                break;
            case 3:
                numeroR = "III";
                break;
            case 4:
                numeroR = "IV";
                break;
            case 5:
                numeroR = "V";
                break;
            case 6:
                numeroR = "VI";
                break;
            case 7:
                numeroR = "VII";
                break;
            case 8:
                numeroR = "VIII";
                break;
            case 9:
                numeroR = "IX";
                break;
            case 10:
                numeroR = "X";
                break;
            case 20:
                numeroR = "XX";
                break;
            case 30:
                numeroR = "XXX";
                break;
            case 40:
                numeroR = "XL";
                break;
            case 50:
                numeroR = "L";
                break;
            case 60:
                numeroR = "LX";
                break;
            case 70:
                numeroR = "LXX";
                break;
            case 80:
                numeroR = "LXXX";
                break;
            case 90:
                numeroR = "XC";
                break;
            case 100:
                numeroR = "C";
                break;
            case 200:
                numeroR = "CC";
                break;
            case 300:
                numeroR = "CCC";
                break;
            case 400:
                numeroR = "CD";
                break;
            case 500:
                numeroR = "D";
                break;
            case 600:
                numeroR = "DC";
                break;
            case 700:
                numeroR = "DCC";
                break;
            case 800:
                numeroR = "DCCC";
                break;
            case 900:
                numeroR = "CM";
                break;
            case 1000:
                numeroR = "M";
                break;

            default:
                numeroR = "G";
                break;
        }
        return numeroR;
    }

}
