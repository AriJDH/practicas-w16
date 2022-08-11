package com.bootcamp.romannumbers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomannumbersController {

    @GetMapping("/convert/{number}")
    public String toRoman(@PathVariable Integer number) {
        int[] numbers = {1000,900,500,400,100,90,50,40,10, 9, 5, 4, 1};
        String[] romanNumbers = {"M","CM","D","CD","C","XC","L","XL", "X", "IX", "V", "IV", "I"};

        String romanNumber = "";
        for (int i = 0; i < numbers.length; i++)
            while (number >= numbers[i]){
                romanNumber+= romanNumbers[i];
                number -= numbers[i];
            }

        return romanNumber.toString();
    }
}
