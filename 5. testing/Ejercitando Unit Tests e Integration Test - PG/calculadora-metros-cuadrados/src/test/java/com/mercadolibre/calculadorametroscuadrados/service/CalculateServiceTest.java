package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

    CalculateService calculateService;

    @Test
    void calculateTest(){
        calculateService = new CalculateService();
        RoomDTO room = new RoomDTO("Habitacion", 100, 20);
        HouseDTO houseDTO = new HouseDTO("Casa 1", "Avenida siempre viva1", List.of(room));
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
        HouseResponseDTO compreHouseDTO = new HouseResponseDTO(2000, 1600000, room);
        assertEquals(compreHouseDTO,houseResponseDTO);

    }

    @Test
    void calculateNoRoomsTest(){
        calculateService = new CalculateService();
        HouseDTO houseDTO = new HouseDTO("Casa 1", "Avenida siempre viva1", List.of());
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
        HouseResponseDTO compreHouseDTO = new HouseResponseDTO(0, 0, null);
        assertEquals(compreHouseDTO,houseResponseDTO);

    }

    @Test
    void calculateTwoRoomsTest(){
        calculateService = new CalculateService();
        RoomDTO room = new RoomDTO("Habitacion", 100, 20);
        RoomDTO room1 = new RoomDTO("Habitacion1", 100, 10);
        HouseDTO houseDTO = new HouseDTO("Casa 1", "Avenida siempre viva1", List.of(room, room1));
        HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
        HouseResponseDTO compreHouseDTO = new HouseResponseDTO(3000, 2400000, room);
        assertEquals(compreHouseDTO,houseResponseDTO);

    }






}