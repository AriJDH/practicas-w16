package com.mercadolibre.calculadorametroscuadrados;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Arrays;

public class TestUtils {

    public static HouseDTO getHouseWith2Rooms(){
        HouseDTO house = new HouseDTO();
        house.setRooms(Arrays.asList(getSmallRoom(),getLargeRoom()));
        house.setName("Monoambiente");
        house.setAddress("FakeSt 123");
        return house;

    }

    public static HouseDTO getHouseWith10x10Room(){

        HouseDTO house = new HouseDTO();
        house.setRooms(Arrays.asList(getSmallRoom()));
        house.setName("Dos Ambientes");
        house.setAddress("FakeSt 123");
        return house;

    }

    public static RoomDTO getSmallRoom(){
        RoomDTO mockSmallRoom = new RoomDTO();
        mockSmallRoom.setLength(10);
        mockSmallRoom.setWidth(10);
        mockSmallRoom.setName("Peque");
        return mockSmallRoom;
    }

    public static RoomDTO getLargeRoom(){
        RoomDTO mockLargeRoom = new RoomDTO();
        mockLargeRoom.setLength(100);
        mockLargeRoom.setWidth(100);
        mockLargeRoom.setName("Grande");
        return mockLargeRoom;
    }
}
