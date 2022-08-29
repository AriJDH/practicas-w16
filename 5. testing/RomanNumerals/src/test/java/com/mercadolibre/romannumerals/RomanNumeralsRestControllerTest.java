package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsRestControllerTest {
    @Autowired
    private RomanNumeralsRestController romanNumeralsRestController;

    @Test
    public void oneToRomanNumeralTest() {
        int numberToConvert = 1;
        String result = this.romanNumeralsRestController.toRoman(numberToConvert);
        Assertions.assertEquals("I", result);
    }

    @Test
    public void threeToRomanNumeralTest() {
        int numberToConvert = 3;
        String result = this.romanNumeralsRestController.toRoman(numberToConvert);
        Assertions.assertEquals("III", result);
    }

    @Test
    public void fiveToRomanNumeralTest() {
        int numberToConvert = 5;
        String result = this.romanNumeralsRestController.toRoman(numberToConvert);
        Assertions.assertEquals("V", result);
    }

    @Test
    public void sevenToRomanNumeralTest() {
        int numberToConvert = 7;
        String result = this.romanNumeralsRestController.toRoman(numberToConvert);
        Assertions.assertEquals("VII", result);
    }

    @Test
    public void tenToRomanNumeralTest() {
        int numberToConvert = 10;
        String result = this.romanNumeralsRestController.toRoman(numberToConvert);
        Assertions.assertEquals("X", result);
    }

    @Test
    public void fiftyToRomanNumeralTest() {
        int numberToConvert = 50;
        String result = this.romanNumeralsRestController.toRoman(numberToConvert);
        Assertions.assertEquals("L", result);
    }
}
