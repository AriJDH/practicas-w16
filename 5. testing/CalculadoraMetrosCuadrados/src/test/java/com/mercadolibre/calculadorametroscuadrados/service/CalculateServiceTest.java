package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTest {
    @Autowired
    private CalculateService calculateService;

    @Test
    public void calculateWithDataTest() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Casa X");
        houseDTO.setAddress("Calle Falsa 123.");

        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Habitación principal");
        roomDTO1.setLength(20);
        roomDTO1.setWidth(20);

        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Habitación secundaria");
        roomDTO2.setLength(30);
        roomDTO2.setWidth(30);

        List<RoomDTO> roomDTOList = Arrays.asList(roomDTO1, roomDTO2);
        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO houseResponseDTOResult = this.calculateService.calculate(houseDTO);

        assertEquals(1040000, houseResponseDTOResult.getPrice());
        assertEquals("Habitación secundaria", houseResponseDTOResult.getBiggest().getName());
    }
}
