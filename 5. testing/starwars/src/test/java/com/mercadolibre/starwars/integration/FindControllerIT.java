package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCharactersWithNameLukeShouldReturnListWithOneCharacter() throws Exception {
        var response =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        List<CharacterDTO> characters =
                new ObjectMapper().readValue(
                        response.getResponse().getContentAsString(),
                        new TypeReference<List<CharacterDTO>>(){}
                );

        Assertions.assertTrue(characters.size() == 1);
        Assertions.assertEquals(characters.get(0).getName(), "Luke Skywalker");
    }

    @Test
    void getTwoMatchedCharactersByName() throws Exception {
        var response =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/{query}", "Darth"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        List<CharacterDTO> characters =
                new ObjectMapper().readValue(
                        response.getResponse().getContentAsString(),
                        new TypeReference<List<CharacterDTO>>(){}
                );

        Assertions.assertTrue(characters.size() == 2);
        characters.forEach(
                characterDTO ->
                        Assertions.assertTrue(characterDTO.getName().contains("Darth"))
        );
    }
}
