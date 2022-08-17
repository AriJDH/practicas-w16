package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanNumeralsRestControllerTests {

    RomanNumeralsRestController controller = new RomanNumeralsRestController();

    @Test
    @DisplayName("Entrada: 1 - Salida: I")
    void test1(){
        assertEquals("I", controller.toRoman(1));
    }

    @Test
    @DisplayName("Entrada: 3 - Salida: III")
    void test2(){
        assertEquals("III", controller.toRoman(3));
    }

    @Test
    @DisplayName("Entrada: 5 - Salida: V")
    void test3(){
        assertEquals("V", controller.toRoman(5));
    }

    @Test
    @DisplayName("Entrada: 7 - Salida: VII")
    void test4(){
        assertEquals("VII", controller.toRoman(7));
    }

    @Test
    @DisplayName("Entrada: 10 - Salida: X")
    void test5(){
        assertEquals("X", controller.toRoman(10));
    }

    @Test
    @DisplayName("Entrada: 50 - Salida: L")
    void test6(){
        assertEquals("L", controller.toRoman(50));
    }

}
