package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsRestControllerTest {

    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @Test
    public void given1ThenReturnI(){

        //arrange
        Integer numberToCast = 1;


        //Act
        String roman = controller.toRoman(numberToCast);


        //Assert
        assertEquals("I", roman);
    }

    @Test
    public void given3ThenReturnIII(){

        //arrange
        Integer numberToCast = 3;


        //Act
        String roman = controller.toRoman(numberToCast);


        //Assert
        assertEquals("III", roman);
    }

    @Test
    public void given5ThenReturnV(){

        //arrange
        Integer numberToCast = 5;


        //Act
        String roman = controller.toRoman(numberToCast);


        //Assert
        assertEquals("V", roman);
    }

    @Test
    public void given7ThenReturnVII(){

        //arrange
        Integer numberToCast = 7;


        //Act
        String roman = controller.toRoman(numberToCast);


        //Assert
        assertEquals("VII", roman);
    }

    @Test
    public void given10ThenReturnX(){

        //arrange
        Integer numberToCast = 10;


        //Act
        String roman = controller.toRoman(numberToCast);


        //Assert
        assertEquals("X", roman);
    }

    @Test
    public void given50ThenReturnL(){

        //arrange
        Integer numberToCast = 50;


        //Act
        String roman = controller.toRoman(numberToCast);


        //Assert
        assertEquals("L", roman);
    }

}