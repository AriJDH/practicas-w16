package com.bootcamp.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosRomanosController {

    @GetMapping
    public String holamundo() {
        return "Hola Mundo!";
    }

    @GetMapping("/d2r/{number}")
    public String decimalToRoman(@PathVariable int number) {
        if(number >= 1 && number <= 4000) {
            StringBuilder sb = new StringBuilder();
            int[] bases = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int i = 0;
            while(number > 0) {
                int div = number/bases[i];
                number = number%bases[i];
                for(; div>0; div--)
                    sb.insert(sb.length(), symbols[i]);
                i++;
            }
            return sb.toString();
        }
        return "Out of range";
    }
}
