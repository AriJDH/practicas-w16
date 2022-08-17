package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

public class NumerosRomanosTest {
    RomanNumeralsRestController roman;
    @BeforeEach
    void initData(){
        roman=new RomanNumeralsRestController();
    }
    @Test
    void romanNumer1Test(){

        funcPrueba(1,"I");

    }
    @Test
    void romanNumer10Test(){

        funcPrueba(10,"X");

    }

    void funcPrueba(int numero,String esperado){

        String result=roman.toRoman(numero);
        Assertions.assertEquals(esperado,result);

    }

}
