package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.utils.Data.getHouseDTO;
import static com.mercadolibre.calculadorametroscuadrados.utils.Data.getHouseResponseDTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter ow = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @DisplayName("return HouseResponseDTO when given HouseDTO")
    @Test
    void integrationTest() throws Exception {


        HouseResponseDTO expectedHouse = getHouseResponseDTO();
        HouseDTO houseDto = getHouseDTO();

        String payload = ow.writeValueAsString(houseDto);
        String expected = ow.writeValueAsString(expectedHouse);

         MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON).content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expected,result.getResponse().getContentAsString());


    }

}