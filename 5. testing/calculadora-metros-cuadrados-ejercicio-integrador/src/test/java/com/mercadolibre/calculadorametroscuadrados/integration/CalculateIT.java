package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }


    @Test
    void postCalculateForHouseWithoutRooms() throws Exception {
        HouseDTO house =
                new HouseDTO("Casa", "1233", List.of());

        var houseAsJson = writer.writeValueAsString(house);

        var response =
                mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(houseAsJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();

        HouseResponseDTO parsedResponse =
                new ObjectMapper().readValue(response.getResponse().getContentAsString(), HouseResponseDTO.class);

        assertThat(parsedResponse.getBiggest()).isEqualTo(null);
        assertThat(parsedResponse.getPrice()).isEqualTo(0);
        assertThat(parsedResponse.getSquareFeet()).isEqualTo(0);
    }

    @Test
    void postCalculateHouseDataForHouseWithTwoRooms() throws Exception {
        RoomDTO biggestRoom = new RoomDTO("Entrada", 3, 5);
        HouseDTO house =
                new HouseDTO("Casa", "1233", List.of(
                        new RoomDTO("Living", 2, 4),
                        biggestRoom
                ));

        var houseAsJson = writer.writeValueAsString(house);

        mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(houseAsJson))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.price").value((3*5 + 2*4) * 800))
                        .andExpect(jsonPath("$.squareFeet").value((3*5 + 2*4)));

    }

}
