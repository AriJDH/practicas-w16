package com.mercadolibre.calculadorametroscuadrados;

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

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Integracion {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void ControllerTest() throws Exception {
        HouseDTO payloadHouseDTO = new HouseDTO();
        payloadHouseDTO.setName("casaLLave");
        payloadHouseDTO.setAddress("calle false 123");
        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("principal");
        roomDTO1.setLength(20);
        roomDTO1.setWidth(20);
        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("segunda");
        roomDTO2.setLength(30);
        roomDTO2.setWidth(30);
        List<RoomDTO> roomDTOS = Arrays.asList(roomDTO1, roomDTO2);
        payloadHouseDTO.setRooms(roomDTOS);
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO();
        houseResponseDTO.setPrice(1040000);
        houseResponseDTO.setSquareFeet(1300);
        houseResponseDTO.setAddress("calle false 123");
        houseResponseDTO.setName("casaLLave");
        houseResponseDTO.setRooms(roomDTOS);
        houseResponseDTO.setBiggest(roomDTO2);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadjson = writer.writeValueAsString(payloadHouseDTO);
        String responseJson = writer.writeValueAsString(houseResponseDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadjson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
                //.andReturn();

        //Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());


    }


}
