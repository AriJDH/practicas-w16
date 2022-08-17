package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.HouseUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    public void testCalculate(){

        //Arrange
        HouseDTO houseDTO = HouseUtil.createHouse();
        HouseResponseDTO houseResponseDTO = HouseUtil.createHouseResponseDto();
        when(calculateService.calculate(any())).thenReturn(houseResponseDTO);

        //Act
        HouseResponseDTO actual = calculateRestController.calculate(houseDTO);

        //Assert
        assertEquals(houseResponseDTO.getName(), actual.getName());

    }

}