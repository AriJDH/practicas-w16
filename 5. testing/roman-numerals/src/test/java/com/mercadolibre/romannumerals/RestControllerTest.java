package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RestControllerTest {

    RomanNumeralsRestController controller;

    @BeforeEach
    void init() {
        controller = new RomanNumeralsRestController();
    }

    @Test
    void testNumberOne() {
        var expectedOutput = "I";

        var output = controller.toRoman(1);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberthree() {
        var expectedOutput = "III";

        var output = controller.toRoman(3);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberFour() {
        var expectedOutput = "IV";

        var output = controller.toRoman(4);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberFive() {
        var expectedOutput = "V";

        var output = controller.toRoman(5);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberSeven() {
        var expectedOutput = "VII";

        var output = controller.toRoman(7);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberNine() {
        var expectedOutput = "IX";

        var output = controller.toRoman(9);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberTen() {
        var expectedOutput = "X";

        var output = controller.toRoman(10);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberForty() {
        var expectedOutput = "XL";

        var output = controller.toRoman(40);

        Assertions.assertEquals(expectedOutput, output);

    }

    @Test
    void testNumberFifty() {
        var expectedOutput = "L";

        var output = controller.toRoman(50);

        Assertions.assertEquals(expectedOutput, output);

    }


}
