package com.mercadolibre.starwars.controller.controller.IntegrationTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
public class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    static CharacterRepository characterRepository = new CharacterRepositoryImpl();


    @Test
    public void findTest() throws Exception {
        //Arrange
        CharacterDTO vader = new CharacterDTO("Darth Vader", "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human", 202, 136);
        CharacterDTO maul = new CharacterDTO("Darth Maul", "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak", 175, 80);
        List<CharacterDTO> expectedValue = Arrays.asList(vader, maul);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        //Act
        MvcResult output =
                mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Darth"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        // Assert
        Assertions.assertEquals(writer.writeValueAsString(expectedValue), output.getResponse().getContentAsString());

    }
}