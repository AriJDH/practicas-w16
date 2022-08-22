package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ModelCreator {
    public static HouseDTO createHouse(String name){
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName(name);
        houseDTO.setAddress("Calle falsa 123");
        houseDTO.setRooms(Arrays.asList(
                createBigRoom(),
                createIntermediateRoom(),
                createSmallRoom()
        ));
        return houseDTO;
    }


    public static RoomDTO createBigRoom(){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Living");
        roomDTO.setLength(30);
        roomDTO.setWidth(30);
        return roomDTO;
    }

    public static RoomDTO createIntermediateRoom(){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Dormitorio");
        roomDTO.setLength(20);
        roomDTO.setWidth(20);
        return roomDTO;
    }

    public static RoomDTO createSmallRoom(){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName("Baño");
        roomDTO.setLength(10);
        roomDTO.setWidth(10);
        return roomDTO;
    }
}
