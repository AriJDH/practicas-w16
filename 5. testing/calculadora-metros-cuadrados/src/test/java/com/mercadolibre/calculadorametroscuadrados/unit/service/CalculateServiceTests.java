package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculateServiceTests {

    @Autowired
    static CalculateService calculateService;

    @BeforeAll
    public static void setup(){
        calculateService = new CalculateService();
    }

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

        // act
        HouseResponseDTO realResponse = calculateService.calculate(house);

        // assert
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

        // act
        HouseResponseDTO realResponse = calculateService.calculate(house);

        // assert
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

        // act
        HouseResponseDTO realResponse = calculateService.calculate(house);

        // assert
        assertEquals(responseDTO, realResponse);
    }

}
