package com.mercadolibre.calculadorametroscuadrados.unitTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateServiceTest {

    CalculateService service;

    @BeforeEach
    void setUp(){
        service = new CalculateService();
    }

    @Test
    @DisplayName("Calcular Precio Total")
    void calculateTest(){
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

        //Act
        HouseResponseDTO houseResponseDTO = service.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(response,houseResponseDTO.getPrice());
    }

    @Test
    @DisplayName("Cuarto mas grande")
    void biggestRoomTest(){
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        RoomDTO roomDTO1 = new RoomDTO();
        RoomDTO roomDTO2 = new RoomDTO();
        RoomDTO biggestRoom = new RoomDTO();
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
            if(response < room.getSquareFeet())
                biggestRoom = room;
        }


        //Act
        HouseResponseDTO houseResponseDTO = service.calculate(houseDTO);

        //Assert

        Assertions.assertEquals(biggestRoom,houseResponseDTO.getBiggest());
    }

    @Test
    @DisplayName("Calcular Metros Cuadrados Por Habitacion")
    void calculateSquareFeet(){

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

        //Act
        HouseResponseDTO houseResponseDTO = service.calculate(houseDTO);
        int i=0;
        //Assert
        for (RoomDTO room: roomDTOS) {
            Assertions.assertEquals(room.getSquareFeet(), houseResponseDTO.getRooms().get(i).getSquareFeet());
            i++;
        }
    }

}
