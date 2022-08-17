package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.HouseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    public void init(){
        calculateService = new CalculateService();
    }

    @Test
    public void testCalculatePropertyValue(){

        //Arrange
        HouseDTO houseToCalculate = HouseUtil.createHouse();


        //act
        HouseResponseDTO actual = calculateService.calculate(houseToCalculate);

        //Assert
        assertEquals( 5040,actual.getSquareFeet() );
        assertEquals("Living room", actual.getBiggest().getName());
        assertEquals(4032000, actual.getPrice());
        assertEquals("HouseName", actual.getName());
        assertEquals("Street 4", actual.getAddress());
        assertEquals("Bedroom", actual.getRooms().get(0).getName());
        assertEquals("Living room", actual.getRooms().get(1).getName());
        assertEquals(40, actual.getRooms().get(0).getSquareFeet());
        assertEquals(5000, actual.getRooms().get(1).getSquareFeet());
    }

}