package com.mercadolibre.calculadorametroscuadrados.unit.util;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class TestUtilsGenerator {

    public static HouseDTO getHouseWithoutRooms() {
        return new HouseDTO("Departamento", "Calle 123", List.of());
    }

    public static HouseDTO getHouseWith3Rooms() {
        RoomDTO bath = new RoomDTO("Bath", 5, 3);
        RoomDTO room = new RoomDTO("Room", 5, 4);
        RoomDTO kitchen = new RoomDTO("Kitchen", 5, 5);
        return new HouseDTO("Departamento", "Calle 123", List.of(bath, room, kitchen));
    }


}
