package com.mercadolibre.calculadorametroscuadrados.unit.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseUtil {
    public static HouseDTO generateHouseDTO() {
        RoomDTO room1 = new RoomDTO();
        room1.setLength(50);
        room1.setWidth(50);
        RoomDTO room2 = new RoomDTO();
        room2.setWidth(100);
        room2.setLength(100);

        List<RoomDTO> roomList = new ArrayList<>(List.of(room1, room2));

        HouseDTO house = new HouseDTO();
        house.setRooms(roomList);
        return house;
    }
}
