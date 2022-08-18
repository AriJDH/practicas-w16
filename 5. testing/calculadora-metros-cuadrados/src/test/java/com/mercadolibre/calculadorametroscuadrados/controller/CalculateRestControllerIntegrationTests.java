package com.mercadolibre.calculadorametroscuadrados.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculatePrice() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();


        String payloadString = writer.writeValueAsString(inputHouse);
        //Act
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.price").value(440000));
        //Assert

    }
    @Test
    public void calculateBiggestTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();


        String payloadString = writer.writeValueAsString(inputHouse);
        //Act
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.biggest.name").value("Room1"));
        //Assert

    }
    @Test
    public void calculateSqFeetTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();


        String payloadString = writer.writeValueAsString(inputHouse);
        //Act
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.squareFeet").value(550));
        //Assert

    }
    @Test
    public void calculateGeneratedValueTest() throws Exception{
        //Arrange
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        HouseDTO inputHouse = generateTestHouse();
        HouseResponseDTO expectedHouse = generateTestHouseReponse();

        String payloadString = writer.writeValueAsString(inputHouse);
        //Act
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        //Assert
        Assertions.assertEquals(writer.writeValueAsString(expectedHouse),mvcResult.getResponse().getContentAsString());

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
