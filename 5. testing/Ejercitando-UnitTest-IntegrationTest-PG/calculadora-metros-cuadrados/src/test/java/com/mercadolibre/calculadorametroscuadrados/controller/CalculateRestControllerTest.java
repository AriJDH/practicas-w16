package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    @DisplayName("Calcular el precio de la propiedad llamando desde el controllador")
    void calculateControllerPriceTest() {

        //Arrange
        HouseResponseDTO houseResponse = new HouseResponseDTO();
        HouseResponseDTO response;
        HouseDTO house = new HouseDTO();

        RoomDTO roomOne = new RoomDTO();
        RoomDTO roomTwo = new RoomDTO();

        roomOne.setName("habitacion 1");
        roomOne.setLength(39);
        roomOne.setWidth(34);

        roomTwo.setName("habitacion 2");
        roomTwo.setLength(54);
        roomTwo.setWidth(35);

        List<RoomDTO> listRooms = new ArrayList<>(Arrays.asList(roomOne,roomTwo));

        house.setName("Casa Campestre");
        house.setAddress("Vía Lejos km 5");
        house.setRooms(listRooms);

        Integer totalArea = 0;
        Integer totalPrice = 0;

        for (RoomDTO r : listRooms) {
            totalArea += r.getSquareFeet();
        }

        totalPrice = totalArea * 800;

        houseResponse.setAddress(house.getAddress());
        houseResponse.setName(house.getName());
        houseResponse.setRooms(house.getRooms());
        houseResponse.setBiggest(roomTwo);
        houseResponse.setPrice(totalPrice);
        houseResponse.setSquareFeet(totalArea);

        Mockito.when(calculateService.calculate(house)).thenReturn(houseResponse);

        //Act
        response = calculateRestController.calculate(house);

        //Assert
        Assertions.assertEquals(totalPrice, response.getPrice());

    }


    @Test
    @DisplayName("Calcular habitacion con la dimension mas grande llamando desde el controlador")
    void calculateControllerBiggestTest() {

        //Arrange
        HouseResponseDTO houseResponse = new HouseResponseDTO();
        HouseDTO house = new HouseDTO();
        HouseResponseDTO response;

        RoomDTO roomOne = new RoomDTO();
        RoomDTO roomTwo = new RoomDTO();
        RoomDTO habitacionMayor = new RoomDTO();

        roomOne.setName("habitacion 1");
        roomOne.setLength(39);
        roomOne.setWidth(90);

        roomTwo.setName("habitacion 2");
        roomTwo.setLength(51);
        roomTwo.setWidth(32);

        List<RoomDTO> listRooms = new ArrayList<>(Arrays.asList(roomOne,roomTwo));

        house.setName("Casa Perez");
        house.setAddress("Calle 44 # 21 -24");
        house.setRooms(listRooms);

        Integer totalArea = 0;
        Integer total = 0;

        for (RoomDTO r : listRooms) {
            totalArea = r.getSquareFeet();
            if (totalArea > total) {
                total = totalArea;
                habitacionMayor = r;
            }
        }

        Integer totalPrice = totalArea * 800;

        houseResponse.setAddress(house.getAddress());
        houseResponse.setName(house.getName());
        houseResponse.setRooms(house.getRooms());
        houseResponse.setBiggest(roomOne);
        houseResponse.setPrice(totalPrice);
        houseResponse.setSquareFeet(totalArea);

        Mockito.when(calculateService.calculate(house)).thenReturn(houseResponse);

        //Act
        response = calculateRestController.calculate(house);

        //Assert
        Assertions.assertEquals(habitacionMayor, response.getBiggest());

    }


    @Test
    @DisplayName("Calcular cantidad de metros cuadrados por habitacion llamando desde el controlador")
    void calculateControllerSquareFeetTest() {

        //Arrange
        HouseResponseDTO houseResponse = new HouseResponseDTO();
        HouseDTO house = new HouseDTO();
        HouseResponseDTO response;

        RoomDTO roomOne = new RoomDTO();
        RoomDTO roomTwo = new RoomDTO();

        roomOne.setName("habitacion 1");
        roomOne.setLength(43);
        roomOne.setWidth(31);

        roomTwo.setName("habitacion 2");
        roomTwo.setLength(59);
        roomTwo.setWidth(67);

        List<RoomDTO> listRooms = new ArrayList<>(Arrays.asList(roomOne,roomTwo));

        house.setName("Casa Quinta");
        house.setAddress("Avenida 26");
        house.setRooms(listRooms);

        //Act

        houseResponse.setAddress(house.getAddress());
        houseResponse.setName(house.getName());
        houseResponse.setRooms(house.getRooms());
        houseResponse.setBiggest(roomOne);

        Mockito.when(calculateService.calculate(house)).thenReturn(houseResponse);

        //Act
        response = calculateRestController.calculate(house);

        //Assert
        for (int i=0; i<listRooms.size(); i++) {
            Assertions.assertEquals(listRooms.get(i).getSquareFeet(), response.getRooms().get(i).getSquareFeet());
        }

    }


}