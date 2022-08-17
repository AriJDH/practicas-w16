package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoomDTOTest {

    @Test
    void calculateFeetsForRoom() {
        RoomDTO room = new RoomDTO("Cocina", 5, 10);

        Assertions.assertEquals(room.getSquareFeet(), 50);
    }

}
