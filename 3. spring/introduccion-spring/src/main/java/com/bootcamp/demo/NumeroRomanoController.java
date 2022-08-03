package com.bootcamp.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroRomanoController {

    @GetMapping("/num/{number}")
    public String solution(@PathVariable int number) {
        String romanNumbers[] = {"M", "CMXC", "CM", "D", "CDXC", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int num[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (number > 0 || num.length == (i - 1)) {
            while ((number - num[i]) >= 0) {
                number -= num[i];
                result.append(romanNumbers[i]);
            }
            i++;
        }

        System.out.println("el numero es: "+result);
        return result.toString();
    }
}
