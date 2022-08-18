package com.mercadolibre.calculadorametroscuadrados.unitTest;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    @Test
    void calculatePrice(){
        //Arrange

        HouseDTO houseDTO = new HouseDTO();
        RoomDTO roomDTO1 = new RoomDTO();
        RoomDTO roomDTO2 = new RoomDTO();
        List<RoomDTO> roomDTOS = new ArrayList<>();

        roomDTO1.setName("Habitacion 1");
        roomDTO1.setLength(2);
        roomDTO1.setWidth(4);

        roomDTO2.setName("Habitacion 2");
        roomDTO2.setLength(3);
        roomDTO2.setWidth(5);

        roomDTOS.add(roomDTO1);
        roomDTOS.add(roomDTO2);

        houseDTO.setName("Casa Mariana");
        houseDTO.setAddress("Carrera 13");
        houseDTO.setRooms(roomDTOS);

        Integer response = 0;
        for (RoomDTO room: roomDTOS) {
            response += room.getSquareFeet();
        }

        response = response * 800;
        HouseResponseDTO expectedDTO= new HouseResponseDTO();
        expectedDTO.setName("Casa Mariana");
        expectedDTO.setPrice(response);
        expectedDTO.setBiggest(roomDTO2);
        expectedDTO.setAddress("carrera2");
        expectedDTO.setSquareFeet(1400);
        expectedDTO.setRooms(roomDTOS);
        //Act

        when(service.calculate(houseDTO)).thenReturn(expectedDTO);
        HouseResponseDTO responseDTO = controller.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(responseDTO.getPrice(),expectedDTO.getPrice());
    }

}
