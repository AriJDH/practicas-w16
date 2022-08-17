package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerUnitTests {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void CalculateTest(){
        // arrange
        HouseDTO house = Utils.buildHouse();
        HouseResponseDTO response = Utils.buildResponseHouse(house);

        when(service.calculate(house)).thenReturn(response);

        // act
        // assert
        Assertions.assertEquals(response, controller.calculate(house));
        Mockito.verify(service, Mockito.atLeastOnce()).calculate(house);
    }
}
