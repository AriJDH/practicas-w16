package com.mercadolibre.romannumerals.controller;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsTest {

    private RomanNumeralsRestController controller;

    public RomanNumeralsTest() {
        this.controller = new RomanNumeralsRestController();
    }

    @Test
    public void shouldbeI() {
        performTest(1, "I");
    }

    @Test
    public void shouldBeIII() {
        performTest(3, "III");
    }

    @Test
    public void shouldBeV() {
        performTest(5, "V");
    }

    @Test
    public void shouldBeVII() {
        performTest(7, "VII");
    }

    @Test
    public void shouldBeX() {
        performTest(10, "X");
    }

    @Test
    public void shouldBeL() {
        performTest(50, "L");
    }

    private void performTest(Integer value, String roman) {
        //Arrange
        Integer number = value;
        //Act
        String result = controller.toRoman(number);
        //Assert
        Assertions.assertEquals(roman, result);
    }
}
