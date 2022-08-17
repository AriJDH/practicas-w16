package com.bootcamp.starwars.integration;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void parsearPersonajesTest() throws Exception {
        List<PersonajeDTO> expectedCharList = new ArrayList<>();
        expectedCharList.add(new PersonajeDTO("Anakin Skywalker", "188", "84", "blond", "fair", "blue", "41.9BBY", "male",
                "Tatooine", "Human"));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        //String expectedResponse = writer.writeValueAsString(expectedCharList);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/carga/{name}", "Anakin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Anakin Skywalker"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}