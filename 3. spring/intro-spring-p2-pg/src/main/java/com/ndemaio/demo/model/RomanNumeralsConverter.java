package com.ndemaio.demo.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RomanNumeralsConverter {

    private final String[] ROMAN_LETTERS = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private final int[] ROMAN_NUMBERS = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

    public String convert(Integer aNumber) {
        StringBuilder roman = new StringBuilder();

        for(int i=0; i < ROMAN_NUMBERS.length; i++)
        {
            while(aNumber >= ROMAN_NUMBERS[i])
            {
                aNumber = aNumber - ROMAN_NUMBERS[i];
                roman.append(ROMAN_LETTERS[i]);
            }
        }
        return roman.toString();
    }
}
