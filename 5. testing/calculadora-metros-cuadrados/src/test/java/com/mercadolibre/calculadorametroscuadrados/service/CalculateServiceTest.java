package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceTest {

    CalculateService service = new CalculateService();

    @Test
    public void calculateSquareFeetTest() {
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();
        RoomDTO room3 = new RoomDTO();
        room1.setWidth(3);
        room1.setLength(3);
        room3.setWidth(2);
        room3.setLength(4);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        HouseResponseDTO response = service.calculate(house);

        assertEquals(rooms.stream().mapToInt(RoomDTO::getSquareFeet).sum(), response.getSquareFeet());
    }

    @Test
    public void calculatePriceTest() {
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();
        RoomDTO room3 = new RoomDTO();
        room1.setWidth(3);
        room1.setLength(3);
        room3.setWidth(2);
        room3.setLength(4);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        HouseResponseDTO response = service.calculate(house);

        assertEquals(rooms.stream().mapToInt(RoomDTO::getSquareFeet).sum()*800, response.getPrice());
    }

    @Test
    public void calculateBiggestTest() {
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();
        RoomDTO room3 = new RoomDTO();
        room1.setWidth(3);
        room1.setLength(3);
        room3.setWidth(2);
        room3.setLength(4);
        List<RoomDTO> rooms = List.of(room1, room2, room3);
        HouseDTO house = new HouseDTO();
        house.setRooms(rooms);

        HouseResponseDTO response = service.calculate(house);

        assertEquals(room1, response.getBiggest());
    }
}
