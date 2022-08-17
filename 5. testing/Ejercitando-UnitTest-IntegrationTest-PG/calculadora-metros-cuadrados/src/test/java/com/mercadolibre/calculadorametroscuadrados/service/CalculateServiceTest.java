package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    void setUp(){
        calculateService = new CalculateService();
    }

    @Test
    @DisplayName("Calcular precio total")
    void calculatePriceTest() {

        //Arrange
        HouseResponseDTO houseResponse = new HouseResponseDTO();
        HouseDTO house = new HouseDTO();

        RoomDTO roomOne = new RoomDTO();
        RoomDTO roomTwo = new RoomDTO();

        roomOne.setName("habitacion 1");
        roomOne.setLength(45);
        roomOne.setWidth(80);

        roomTwo.setName("habitacion 2");
        roomTwo.setLength(54);
        roomTwo.setWidth(33);

        List<RoomDTO> listRooms = new ArrayList<>(Arrays.asList(roomOne,roomTwo));

        house.setName("Casa 33");
        house.setAddress("Calle 33 # 33 - 33");
        house.setRooms(listRooms);

        Integer totalArea = 0;
        Integer totalPrice;

        for (RoomDTO r : listRooms) {
            totalArea += r.getSquareFeet();
        }

        totalPrice = totalArea * 800;

        //Act
        houseResponse = calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(totalPrice, houseResponse.getPrice());

    }

    @Test
    @DisplayName("Calcular habitacion con la dimension mas grande")
    void calculateBiggestTest() {

        //Arrange
        HouseResponseDTO houseResponse;
        HouseDTO house = new HouseDTO();

        RoomDTO roomOne = new RoomDTO();
        RoomDTO roomTwo = new RoomDTO();
        RoomDTO habitacionMayor = new RoomDTO();

        roomOne.setName("habitacion 1");
        roomOne.setLength(19);
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

        //Act
        houseResponse = calculateService.calculate(house);

        //Assert
        Assertions.assertEquals(habitacionMayor, houseResponse.getBiggest());

    }

    @Test
    @DisplayName("Calcular cantidad de metros cuadrados por habitacion")
    void calculateSquareFeetTest() {

        //Arrange
        HouseResponseDTO houseResponse;
        HouseDTO house = new HouseDTO();

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
        houseResponse = calculateService.calculate(house);

        //Assert
        for (int i=0; i<listRooms.size(); i++) {
            Assertions.assertEquals(listRooms.get(i).getSquareFeet(), houseResponse.getRooms().get(i).getSquareFeet());
        }

    }

}