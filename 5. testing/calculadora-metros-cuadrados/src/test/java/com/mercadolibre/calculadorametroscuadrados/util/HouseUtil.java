package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseUtil {

    public static HouseDTO createHouse(){

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("HouseName");
        houseDTO.setAddress("Street 4");

        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Bedroom");
        room1.setLength(5);
        room1.setWidth(8);
        rooms.add(room1);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Living room");
        room2.setWidth(50);
        room2.setLength(100);
        rooms.add(room2);

        houseDTO.setRooms(rooms);

        return  houseDTO;
    }

    public static HouseResponseDTO createHouseResponseDto(){

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();

        houseResponseDTO.setName("HouseName");

        return houseResponseDTO;
    }
}
