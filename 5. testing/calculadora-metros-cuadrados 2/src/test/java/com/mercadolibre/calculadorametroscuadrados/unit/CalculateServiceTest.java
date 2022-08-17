package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.unit.util.HouseUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.mercadolibre.calculadorametroscuadrados.unit.util.HouseUtil.*;

public class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    void init() {
        calculateService = new CalculateService();
    }

    @Test
    @DisplayName("Validar squareFeet")
    void test1() {
        //Arrange
        HouseDTO house = generateHouseDTO();
        Integer expectedSquareFeet = 12500;
        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(expectedSquareFeet, houseResponseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("Validar Biggest Room")
    void test2() {
        //Arrange
        HouseDTO house = generateHouseDTO();

        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(house.getRooms().get(1), houseResponseDTO.getBiggest());
    }

    @Test
    @DisplayName("Validar Square feet by room")
    void test3() {
        //Arrange
        HouseDTO house = generateHouseDTO();
        Integer expectedSquareFeetRoom1 = 2500;
        Integer expectedSquareFeetRoom2 = 10000;

        //Assert
        Assertions.assertEquals(expectedSquareFeetRoom1 ,house.getRooms().get(0).getSquareFeet());
        Assertions.assertEquals(expectedSquareFeetRoom2 ,house.getRooms().get(1).getSquareFeet());
    }

    @Test
    @DisplayName("Validar caluculo de valor de la propiedad")
    void test4() {
        //Arrange
        HouseDTO house = generateHouseDTO();
        Integer expectedPrice = 10000000;

        //Act
        HouseResponseDTO houseResponseDTO = calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(expectedPrice , houseResponseDTO.getPrice());
    }
}
