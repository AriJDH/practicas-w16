package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.utils.Data.getHouseDTO;
import static com.mercadolibre.calculadorametroscuadrados.utils.Data.getHouseResponseDTO;
import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService service = new CalculateService();

    @Test
    void calculate() {

        //arrange
        HouseResponseDTO expectedHouse = getHouseResponseDTO();
        HouseDTO houseDto = getHouseDTO();

        //act
        HouseResponseDTO houseResponseDTO = service.calculate(houseDto);

        //asset
        assertEquals(expectedHouse,houseResponseDTO);
    }

}