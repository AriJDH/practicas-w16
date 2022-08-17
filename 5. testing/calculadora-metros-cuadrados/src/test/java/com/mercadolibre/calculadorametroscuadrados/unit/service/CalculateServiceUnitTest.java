package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.unit.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CalculateServiceUnitTest {

    @Autowired
    private CalculateService calculateService;

    @Test
    void calculateEmptyHouseTest() {
        HouseDTO houseDTO = new HouseDTO();
        Assertions.assertThrows(NullPointerException.class, () ->
                calculateService.calculate(houseDTO));
    }

    @Test
    void calculateNullHouseTest() {
        HouseDTO houseDTO = null;
        Assertions.assertThrows(NullPointerException.class, () ->
                calculateService.calculate(houseDTO));
    }

    @Test
    void calculateHouseWithoutRoomsTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWithoutRooms();

        HouseResponseDTO res = calculateService.calculate(houseDTO);

        Assertions.assertEquals(0, res.getPrice());
        Assertions.assertEquals(0, res.getSquareFeet());
        Assertions.assertNull(res.getBiggest());
    }

    @Test
    void calculateHousePriceTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWith3Rooms();

        HouseResponseDTO res = calculateService.calculate(houseDTO);

        Assertions.assertEquals(48000, res.getPrice());
    }

    @Test
    void calculateBiggestRoomTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWith3Rooms();

        HouseResponseDTO res = calculateService.calculate(houseDTO);

        Assertions.assertEquals(res.getBiggest(), houseDTO.getRooms().get(2));
    }

    @Test
    void calculateSquareFeetRoomsTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWith3Rooms();

        HouseResponseDTO res = calculateService.calculate(houseDTO);

        Assertions.assertEquals(15, res.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(20, res.getRooms().get(1).getSquareFeet());
        Assertions.assertEquals(25, res.getRooms().get(2).getSquareFeet());
    }
}
