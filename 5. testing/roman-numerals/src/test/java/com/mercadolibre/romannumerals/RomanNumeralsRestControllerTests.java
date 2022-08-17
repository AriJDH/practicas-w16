package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class RomanNumeralsRestControllerTests {

    static RomanNumeralsRestController controller;

    @BeforeAll
    static void setup(){
        controller = new RomanNumeralsRestController();
    }

    @Test
    void oneShouldBeI() throws Exception {
        performTest("1", "I");
    }

    @Test
    void tenShouldBeX() throws Exception {
        performTest("10", "X");
    }

    @Test
    void sevenShouldBeVII() throws Exception {
        performTest("7", "VII");
    }

    @Test
    void fiftyShouldBeL() throws Exception {
        performTest("50", "L");
    }

    @Test
    void fiftyFiveShouldBeLV() throws Exception {
        performTest("55", "LV");
    }

    @Test
    void emptyStr() throws Exception {
        Assertions.assertThrows(NumberFormatException.class, () -> performTest(" ", " "));
    }

    @Test
    void nullStr() throws Exception {
        Assertions.assertThrows(NumberFormatException.class, () -> performTest(null, " "));
    }


    @Test
    void invalidNumber() throws Exception {
        Assertions.assertThrows(NumberFormatException.class, () -> performTest("numberstr", " "));
    }

    private void performTest(String decimal, String roman) throws Exception {
        String res = controller.toRoman(Integer.valueOf(decimal));

        Assertions.assertEquals(roman, res);
    }
}
