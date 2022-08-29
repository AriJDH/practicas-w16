package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    private CalculateService mockCalculateService;
    @InjectMocks
    private CalculateRestController calculateRestController;

    @Test
    public void calculateRestControllerTest() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa X");
        houseDTO.setAddress("Calle Falsa 123.");

        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Habitación principal");
        roomDTO.setLength(20);
        roomDTO.setWidth(20);

        houseDTO.setRooms(Arrays.asList(roomDTO));

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setSquareFeet(400);
        houseResponseDTO.setPrice(320000);
        houseResponseDTO.setBiggest(roomDTO);

        when(this.mockCalculateService.calculate(houseDTO)).thenReturn(houseResponseDTO);

        HouseResponseDTO houseResponseDTOResult = this.calculateRestController.calculate(houseDTO);

        assertAll(
                () -> assertEquals(400, houseResponseDTOResult.getSquareFeet(), "ASSERT_1: metros cuadrados totales de la casa."),
                () -> assertEquals(320000, houseResponseDTOResult.getPrice(), "ASSERT_2: precio de la casa."),
                () -> assertEquals("Habitación principal", houseResponseDTOResult.getBiggest().getName(), "ASSERT_3: nombre de la única habitación de la casa.")
        );

        verify(this.mockCalculateService, atLeastOnce()).calculate(houseDTO);
    }
}
