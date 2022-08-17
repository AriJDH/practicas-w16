package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.utils.Data.getHouseDTO;
import static com.mercadolibre.calculadorametroscuadrados.utils.Data.getHouseResponseDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    @DisplayName("Return ResponseHouseDTO when given HouseDTO")
    void test1() {

        //arrange
        HouseResponseDTO expectedHouse = getHouseResponseDTO();
        HouseDTO houseDto = getHouseDTO();


        //act
        HouseResponseDTO houseResponseDTO = controller.calculate(houseDto);

        //asset
        assertEquals(expectedHouse,houseResponseDTO);
    }




}