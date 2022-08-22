package com.mercadolibre.romannumerals.testunitario;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RomanNumeralsRestControllerTest {

    @Autowired
    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @Test
    public void toRomanOne() {

        int number = 1;
        String expected = "I";

        String response = controller.toRoman(number);

        Assertions.assertEquals(expected, response);


    }


    @Test
    public void toRomanThree() {

        int number = 3;
        String expected = "III";

        String response = controller.toRoman(number);

        Assertions.assertEquals(expected, response);


    }

    @Test
    public void toRomanFive() {

        int number = 5;
        String expected = "V";

        String response = controller.toRoman(number);

        Assertions.assertEquals(expected, response);


    }

    @Test
    public void toRomanSeven() {

        int number = 7;
        String expected = "VII";

        String response = controller.toRoman(number);

        Assertions.assertEquals(expected, response);


    }


    @Test
    public void toRomanTen() {

        int number = 10;
        String expected = "X";

        String response = controller.toRoman(number);

        Assertions.assertEquals(expected, response);


    }


    @Test
    public void toRomanFifty() {

        int number = 50;
        String expected = "L";

        String response = controller.toRoman(number);

        Assertions.assertEquals(expected, response);


    }

}
