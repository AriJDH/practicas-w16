package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.CalculadoraMetrosCuadradosApplication;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    CalculateRestController calculateRestController  = new CalculateRestController();

    // Debido a que no hay una inyeccion de dependencias de el controller al service, no es necesario usar mocks, ya que en el metodo del controlador
    //se crea una nueva instancia del servicio
    @Test
    public void calculatePriceTest(){
        //Arrange
        HouseDTO inputHouse = generateTestHouse();
        HouseResponseDTO serviceOutput = generateTestHouseReponse();
        //Act
        HouseResponseDTO controllerOutput = calculateRestController.calculate(inputHouse);
        //Assert
        assertEquals(controllerOutput.getPrice(),440000);
    }
    @Test
    public void calculateBiggestTest(){
        //Arrange
        HouseDTO inputHouse = generateTestHouse();
        HouseResponseDTO serviceOutput = generateTestHouseReponse();
        //Act
        HouseResponseDTO controllerOutput = calculateRestController.calculate(inputHouse);
        //Assert
        assertEquals(controllerOutput.getBiggest().getName(),"Room1");
    }
    @Test
    public void calculateSqFeetTest(){
        //Arrange
        HouseDTO inputHouse = generateTestHouse();
        HouseResponseDTO serviceOutput = generateTestHouseReponse();
        //Act
        HouseResponseDTO controllerOutput = calculateRestController.calculate(inputHouse);
        //Assert
        assertEquals(controllerOutput.getSquareFeet(),550);
    }

    @Test
    public void calculateGeneratedValueTest()throws Exception{
        //Arrange
        HouseDTO inputHouse = generateTestHouse();
        HouseResponseDTO expectedOutput = generateTestHouseReponse();
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        //Act
        HouseResponseDTO controllerOutput = calculateRestController.calculate(inputHouse);
        //Assert
        assertEquals(writer.writeValueAsString(expectedOutput),writer.writeValueAsString(controllerOutput));
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
