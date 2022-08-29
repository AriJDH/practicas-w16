package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void calculateRestControllerIntegrationTest() throws Exception {
        HouseDTO payloadHouseDTO = new HouseDTO();
        payloadHouseDTO.setName("Casa X");
        payloadHouseDTO.setAddress("Calle Falsa 123.");
        // Room 1
        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Habitación principal");
        roomDTO1.setLength(20);
        roomDTO1.setWidth(20);
        // Room 2
        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Habitación secundaria");
        roomDTO2.setLength(30);
        roomDTO2.setWidth(30);
        // RoomList
        List<RoomDTO> roomDTOList = Arrays.asList(roomDTO1, roomDTO2);
        payloadHouseDTO.setRooms(roomDTOList);

        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setName("Casa X");
        houseResponseDTO.setAddress("Calle Falsa 123.");
        houseResponseDTO.setSquareFeet(1300);
        houseResponseDTO.setPrice(1040000);
        houseResponseDTO.setRooms(roomDTOList);
        houseResponseDTO.setBiggest(roomDTO2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
        String payloadHouseDTOJson = writer.writeValueAsString(payloadHouseDTO);
        String responseJson = writer.writeValueAsString(houseResponseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadHouseDTOJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }
}
