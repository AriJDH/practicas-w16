package com.example.Romanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerNumbers {

    @GetMapping("/{number}")
    public String getNumberOrdinal(@PathVariable int number) {

        String resultNumberRoman = "";
        int miles = number / 1000;
        int hundreds = number / 100 % 10;
        int tens = number / 10 % 10;
        int units = number % 10;

        resultNumberRoman = convertNumber(units, tens, hundreds, miles);

        return resultNumberRoman;
    }

    private String convertNumber (int units, int tens, int hundreds, int miles) {
        StringBuilder roman = new StringBuilder();
        int i;

        for (i = 1; i <= miles; i++) {
            roman.append("M");
        }

        if (hundreds == 9) {
            roman.append("CM");
        } else if (hundreds >= 5) {
            roman.append("D");
            for (i = 6; i <= hundreds; i++) {
                roman.append("C");
            }
        } else if (hundreds == 4) {
            roman.append("CD");
        } else {
            for (i = 1; i <= hundreds; i++) {
                roman.append("C");
            }
        }

        if (tens == 9) {
            roman.append("XC");
        } else if (tens >= 5) {
            roman.append("L");
            for (i = 6; i <= tens; i++) {
                roman.append("X");
            }
        } else if (tens == 4) {
            roman.append("XL");
        } else {
            for (i = 1; i <= tens; i++) {
                roman.append("X");
            }
        }

        if (units == 9) {
            roman.append("IX");
        } else if (units >= 5) {
            roman.append("V");
            for (i = 6; i <= units; i++) {
                roman.append("I");
            }
        } else if (units == 4) {
            roman.append("IV");
        } else {
            for (i = 1; i <= units; i++) {
                roman.append("I");
            }
        }

        return roman.toString();
    }
}
