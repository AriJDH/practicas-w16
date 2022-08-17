package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void calculateRoom1() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("dormitorio1");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(roomDTO);
        HouseDTO house = new HouseResponseDTO();
        house.setName("casa1");
        house.setRooms(rooms);
        house.setAddress("DIRECCION1");
        HouseResponseDTO responseExpected = new HouseResponseDTO(house);
        responseExpected.setPrice(80000);
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(responseExpected.getPrice(), response.getPrice());
    }
    @Test
    void calculateRoom0() {
        List<RoomDTO> rooms = new ArrayList<>();
        HouseDTO house = new HouseResponseDTO();
        house.setName("casa1");
        house.setRooms(rooms);
        house.setAddress("DIRECCION1");
        HouseResponseDTO responseExpected = new HouseResponseDTO(house);
        responseExpected.setPrice(0);
        responseExpected.setSquareFeet(0);
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(responseExpected, response);
    }

    @Test
    void calculateRoom2() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("dormitorio1");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);
        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("dormitorio2");
        roomDTO2.setLength(20);
        roomDTO2.setWidth(20);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(roomDTO2);
        rooms.add(roomDTO);
        HouseDTO house = new HouseResponseDTO();
        house.setName("casa1");
        house.setRooms(rooms);
        house.setAddress("DIRECCION1");
        HouseResponseDTO responseExpected = new HouseResponseDTO(house);
        responseExpected.setPrice(400000);
        responseExpected.setSquareFeet(500);
        responseExpected.setBiggest(roomDTO2);
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(responseExpected, response);
    }
    @Test
    void calculateBiggerRoom() {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("dormitorio1");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);
        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("dormitorio2");
        roomDTO2.setLength(20);
        roomDTO2.setWidth(20);
        List<RoomDTO> rooms = new ArrayList<>();
        rooms.add(roomDTO2);
        rooms.add(roomDTO);
        HouseDTO house = new HouseResponseDTO();
        house.setName("casa1");
        house.setRooms(rooms);
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(roomDTO2, response.getBiggest());
    }

}