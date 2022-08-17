package com.mercadolibre.calculadorametroscuadrados.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {

    private CalculateService calculateService = new CalculateService();


    @Test
    public void calculatePriceTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();
        //Act
        HouseResponseDTO outputHouseResponse = calculateService.calculate(inputHouse);
        //Assert
        assertEquals(outputHouseResponse.getPrice(),440000);

    }
    @Test
    public void calculateBiggestTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();
        //Act
        HouseResponseDTO outputHouseResponse = calculateService.calculate(inputHouse);
        //Assert
        assertEquals(outputHouseResponse.getBiggest().getName(),"Room1");
    }
    @Test
    public void calculateSqFeetTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();
        //Act
        HouseResponseDTO outputHouseResponse = calculateService.calculate(inputHouse);
        //Assert
        assertEquals(outputHouseResponse.getSquareFeet(),550);
    }




    @Test
    public void calculateGeneratedValueTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();
        HouseResponseDTO expectedResult = generateTestHouseReponse();
        //Act
        HouseResponseDTO outputHouseResponse = calculateService.calculate(inputHouse);
        //Assert
        assertEquals(writer.writeValueAsString(expectedResult),writer.writeValueAsString(outputHouseResponse));
    }



    private HouseDTO generateTestHouse(){
        RoomDTO room1 = new RoomDTO("Room1",12,25);
        RoomDTO room2 = new RoomDTO("Room2",10,18);
        RoomDTO room3 = new RoomDTO("Room3",7,10);
        return new HouseDTO("casa1","742 Evergreen Terrace", Arrays.asList(room1,room2,room3));
    }

    private HouseResponseDTO generateTestHouseReponse(){
        RoomDTO room1 = new RoomDTO("Room1",12,25);
        RoomDTO room2 = new RoomDTO("Room2",10,18);
        RoomDTO room3 = new RoomDTO("Room3",7,10);
        HouseResponseDTO houseResponse = new HouseResponseDTO (new HouseDTO("casa1","742 Evergreen Terrace", Arrays.asList(room1,room2,room3)));
        houseResponse.setBiggest(room1);
        houseResponse.setSquareFeet(550);
        houseResponse.setPrice(440000);
        return houseResponse;
    }

}
