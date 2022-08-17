package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.unit.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateRestControllerUnitTest {
    @Autowired
    private CalculateRestController controller;

    @Test
    void calculateEmptyHouseExceptionTest() {
        HouseDTO houseDTO = new HouseDTO();

        Assertions.assertThrows(NullPointerException.class, ()->
                controller.calculate(houseDTO));
    }

    @Test
    void calculateHouseWithoutRoomsTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWithoutRooms();

        HouseResponseDTO responseDTO = controller.calculate(houseDTO);

        Assertions.assertEquals(responseDTO.getName(), houseDTO.getName());
        Assertions.assertEquals(responseDTO.getAddress(), houseDTO.getAddress());
        Assertions.assertTrue(responseDTO.getRooms().isEmpty());
    }

    @Test
    void calculatePriceTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWith3Rooms();

        HouseResponseDTO responseDTO = controller.calculate(houseDTO);

        Assertions.assertEquals(48000, responseDTO.getPrice());
    }

    @Test
    void calculateBiggestRoomTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWith3Rooms();

        HouseResponseDTO responseDTO = controller.calculate(houseDTO);

        Assertions.assertEquals(responseDTO.getBiggest(), houseDTO.getRooms().get(2));
    }

    @Test
    void calculateSquareFeetRoomsTest() {
        HouseDTO houseDTO = TestUtilsGenerator.getHouseWith3Rooms();

        HouseResponseDTO responseDTO = controller.calculate(houseDTO);

        Assertions.assertEquals(15,  responseDTO.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(20, responseDTO.getRooms().get(1).getSquareFeet());
        Assertions.assertEquals(25, responseDTO.getRooms().get(2).getSquareFeet());
    }
}
