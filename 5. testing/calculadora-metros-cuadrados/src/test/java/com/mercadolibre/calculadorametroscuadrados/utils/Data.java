package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static HouseDTO getHouseDTO(){

        List<RoomDTO> roomList = new ArrayList<>();
        RoomDTO room1 = new RoomDTO("cuarto",1,1);
        RoomDTO room2 = new RoomDTO("living",2,4);
        roomList.add(room1);
        roomList.add(room2);

        return new HouseDTO("casa1","calle55",roomList);
    }

    public static HouseResponseDTO getHouseResponseDTO(){

        List<RoomDTO> roomList = new ArrayList<>();
        RoomDTO room1 = new RoomDTO("cuarto",1,1);
        RoomDTO room2 = new RoomDTO("living",2,4);
        roomList.add(room1);
        roomList.add(room2);

        HouseResponseDTO expectedHouse = new HouseResponseDTO(9,7200,room2);
        expectedHouse.setName("casa1");
        expectedHouse.setAddress("calle55");
        expectedHouse.setRooms(roomList);

        return expectedHouse;
    }

}
