package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RomanNumeralsTests {

    RomanNumeralsRestController controller;

    public RomanNumeralsTests(){
        this.controller = new RomanNumeralsRestController();
    }

    @Test
    public void toRoman0() {
        // arrange
        Integer num = 0;
        String expected = "";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman1() {
        // arrange
        Integer num = 1;
        String expected = "I";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman3() {
        // arrange
        Integer num = 3;
        String expected = "III";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman5() {
        // arrange
        Integer num = 5;
        String expected = "V";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman7() {
        // arrange
        Integer num = 7;
        String expected = "VII";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman10() {
        // arrange
        Integer num = 10;
        String expected = "X";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman400() {
        // arrange
        Integer num = 400;
        String expected = "CD";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman500() {
        // arrange
        Integer num = 500;
        String expected = "D";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman900() {
        // arrange
        Integer num = 900;
        String expected = "CM";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman1000() {
        // arrange
        Integer num = 1000;
        String expected = "M";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }

    @Test
    public void toRoman50() {
        // arrange
        Integer num = 50;
        String expected = "L";

        // act
        String romanNumber = controller.toRoman(num);

        // assert
        assertEquals(expected, romanNumber);
    }
}

