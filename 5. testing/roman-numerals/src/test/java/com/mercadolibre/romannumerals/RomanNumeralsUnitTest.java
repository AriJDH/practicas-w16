package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralsUnitTest {

    RomanNumeralsRestController romanNumeralsController = new RomanNumeralsRestController();

    @Test
    public void unoEsI(){
        Assertions.assertTrue(performTest("1","I"));
    }
    @Test
    public void tresEsIII(){
        Assertions.assertTrue(performTest("3","III"));
    }
    @Test
    public void cincoEsV(){
        Assertions.assertTrue(performTest("5","V"));
    }
    @Test
    public void sieteEsVII(){
        Assertions.assertTrue(performTest("7","VII"));
    }
    @Test
    public void diezEsX(){
        Assertions.assertTrue(performTest("10","X"));
    }
    @Test
    public void cincuentaEsL(){
        Assertions.assertTrue(performTest("50","L"));
    }

    private boolean performTest (String input,String expected ){
        return expected.equalsIgnoreCase(romanNumeralsController.toRoman(Integer.parseInt(input)));
    }
}
