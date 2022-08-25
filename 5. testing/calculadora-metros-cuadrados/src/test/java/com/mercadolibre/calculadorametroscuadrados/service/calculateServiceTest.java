package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.TestUtils;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class calculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void testCalculateHouseSquareFeet() {
        var response = calculateService.calculate(TestUtils.getHouseWith10x10Room());

        Assertions.assertEquals(100,response.getSquareFeet() );

    }

    @Test
    void testBiggerRoom() {
        var response = calculateService.calculate(TestUtils.getHouseWith2Rooms());

        Assertions.assertEquals(response.getBiggest(), TestUtils.getLargeRoom());

    }

    @Test
    void testHousePrice() {
        var response = calculateService.calculate(TestUtils.getHouseWith10x10Room());

        Assertions.assertEquals(response.getPrice(), 100 * 800);
    }


}
