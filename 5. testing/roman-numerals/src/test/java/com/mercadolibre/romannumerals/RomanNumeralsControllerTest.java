package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RomanNumeralsControllerTest {
    RomanNumeralsRestController romanNumeralsRestController;
    String expectedResult;
    Integer number;

    @BeforeEach
    void initializerController(){
        romanNumeralsRestController = new RomanNumeralsRestController();
    }

    @Test
    public void testConvertionRomanNumeral(){
        //Arrange
        expectedResult = "I";
        number=1;
        //Act
        String result = romanNumeralsRestController.toRoman(number);
        //Asserts
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void testConvertionRomanNumeralDos(){
        //Arrange
        expectedResult = "III";
        number=3;
        //Act
        String result = romanNumeralsRestController.toRoman(number);
        //Asserts
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void testConvertionRomanNumeralTres(){
        //Arrange
        expectedResult = "V";
        number = 5;
        //Act
        String result = romanNumeralsRestController.toRoman(number);
        //Asserts
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void testConvertionRomanNumeralCuatro(){
        //Arrange
        expectedResult = "VII";
        number = 7;
        //Act
        String result = romanNumeralsRestController.toRoman(number);
        //Asserts
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void testConvertionRomanNumeralCinco(){
        //Arrange
        expectedResult = "X";
        number = 10;
        //Act
        String result = romanNumeralsRestController.toRoman(number);
        //Asserts
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void testConvertionRomanNumeralSeis(){
        //Arrange
        expectedResult = "L";
        number = 50;
        //Act
        String result = romanNumeralsRestController.toRoman(number);
        //Asserts
        Assertions.assertEquals(expectedResult,result);
    }
}
