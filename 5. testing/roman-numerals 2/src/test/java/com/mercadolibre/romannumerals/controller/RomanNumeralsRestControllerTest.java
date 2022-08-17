package com.mercadolibre.romannumerals.controller;


import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RomanNumeralsRestControllerTest {
    private RomanNumeralsRestController restController;

    @BeforeEach
    void setUp() {
       this.restController = new RomanNumeralsRestController();
    }

    @Test
    void oneShouldReturnI() {
        int one = 1;
        String resultExpected = "I";
        String result = restController.toRoman(one);
        Assertions.assertEquals(result,resultExpected);
    }

    @Test
    void threeShouldReturnIII() {
        int three = 3;
        String resultExpected = "III";
        String result = restController.toRoman(three);
        Assertions.assertEquals(result,resultExpected);

    }

    @Test
    void fiveShouldReturnV() {
        int five = 5;
        String resultExpected = "V";
        String result = restController.toRoman(five);
        Assertions.assertEquals(result,resultExpected);
    }


    @Test
    void sevenShouldReturnVII() {
        int seven = 7;
        String resultExpected = "VII";
        String result = restController.toRoman(seven);
        Assertions.assertEquals(result,resultExpected);
    }

    @Test
    void tenShouldReturnX() {
        int ten = 10;
        String resultExpected = "X";
        String result = restController.toRoman(ten);
        Assertions.assertEquals(result,resultExpected);
    }

    @Test
    void fiftyShouldReturnV() {
        int fifty = 50;
        String resultExpected = "L";
        String result = restController.toRoman(fifty);
        Assertions.assertEquals(result,resultExpected);
    }
}
