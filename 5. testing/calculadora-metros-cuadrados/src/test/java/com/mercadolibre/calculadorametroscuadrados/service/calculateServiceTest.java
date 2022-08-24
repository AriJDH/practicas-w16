package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class calculateServiceTest {

    @Autowired
    CalculateService calculateService;

    RoomDTO mockSmallRoom;
    RoomDTO mockLargeRoom;

    @BeforeEach
    void init(){
        mockSmallRoom = new RoomDTO();
        mockLargeRoom = new RoomDTO();

        mockSmallRoom.setLength(10);
        mockSmallRoom.setWidth(10);
        mockSmallRoom.setName();



    }



    @Test
    void testCalculateHouse(){

    }

}
