package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTests {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculateHouseWithOneRoom() throws Exception {
        // arrange
        RoomDTO room = new RoomDTO("Espacio abierto", 3, 3);
        HouseDTO house = new HouseDTO();
        house.setRooms(new ArrayList<>(List.of(room)));
        house.setName("Oficina");
        house.setAddress("Monroe 800");

        HouseResponseDTO responseDTO = new HouseResponseDTO(house);
        responseDTO.setSquareFeet(9);
        responseDTO.setBiggest(room);
        responseDTO.setPrice(7200);
        when(calculateService.calculate(house)).thenReturn(responseDTO);

        // act
        HouseResponseDTO realResponse = calculateRestController.calculate(house);

        // assert
        verify(calculateService, atLeastOnce()).calculate(house);
        assertEquals(responseDTO, realResponse);
    }

    @Test
    void calculateHouseWithMultipleRoom() throws Exception {
        // arrange
        RoomDTO room1 = new RoomDTO("Espacio abierto", 5, 5);
        RoomDTO room2 = new RoomDTO("Cocina", 3, 3);
        RoomDTO room3 = new RoomDTO("Baño", 2, 1);
        HouseDTO house = new HouseDTO();
        house.setRooms(new ArrayList<>(List.of(room1, room2, room3)));
        house.setName("Oficina");
        house.setAddress("Monroe 800");

        HouseResponseDTO responseDTO = new HouseResponseDTO(house);
        responseDTO.setSquareFeet(36);
        responseDTO.setBiggest(room1);
        responseDTO.setPrice(28800);
        when(calculateService.calculate(house)).thenReturn(responseDTO);

        // act
        HouseResponseDTO realResponse = calculateRestController.calculate(house);

        // assert
        verify(calculateService, atLeastOnce()).calculate(house);
        assertEquals(responseDTO, realResponse);
    }

    @Test
    void calculateHouseWithoutRooms() throws Exception {
        // arrange
        HouseDTO house = new HouseDTO();
        house.setRooms(new ArrayList<>());
        house.setName("Oficina");
        house.setAddress("Monroe 800");

        HouseResponseDTO responseDTO = new HouseResponseDTO(house);
        responseDTO.setSquareFeet(0);
        responseDTO.setBiggest(null);
        responseDTO.setPrice(0);
        when(calculateService.calculate(house)).thenReturn(responseDTO);

        // act
        HouseResponseDTO realResponse = calculateRestController.calculate(house);

        // assert
        verify(calculateService, atLeastOnce()).calculate(house);
        assertEquals(responseDTO, realResponse);
    }

}
