package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsRestControllerTests {

    @Autowired
    private RomanNumeralsRestController controller;

    @Test
    void toRomanWithNumOneTest() {
        Integer numberParam = 1;
        String expected = "I";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);

    }

    @Test
    void toRomanWithNumThreeTest() {
        Integer numberParam = 3;
        String expected = "III";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);

    }

    @Test
    void toRomanWithNumFiveTest() {
        Integer numberParam = 5;
        String expected = "V";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);

    }

    @Test
    void toRomanWithNumSevenTest() {
        Integer numberParam = 7;
        String expected = "VII";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);

    }

    @Test
    void toRomanWithNumTenTest() {
        Integer numberParam = 10;
        String expected = "X";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);

    }
    @Test
    void toRomanWithNumFiftyTest() {
        Integer numberParam = 50;
        String expected = "L";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);

    }

    @Test
    void toRomanNegativeNumTest() {
        Integer numberParam = -1;
        String expected = "";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);
    }

    @Test
    void toRomanWithCeroTest() {
        Integer numberParam = 0;
        String expected = "";
        String response = controller.toRoman(numberParam);
        Assertions.assertEquals(response, expected);
    }
}
