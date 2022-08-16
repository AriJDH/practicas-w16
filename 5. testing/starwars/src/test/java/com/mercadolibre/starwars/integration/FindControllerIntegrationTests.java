package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findTest() throws Exception{

        String query = "darth";

        CharacterDTO ch1 = new CharacterDTO();
        ch1.setName("Darth Vader");
        ch1.setHeight(202);
        ch1.setMass(136);
        ch1.setHairColor("none");
        ch1.setSkinColor("white");
        ch1.setEyeColor("yellow");
        ch1.setBirthYear("41.9BBY");
        ch1.setGender("male");
        ch1.setHomeWorld("Tatooine");
        ch1.setSpecies("Human");

        CharacterDTO ch2 = new CharacterDTO();
        ch2.setName("Darth Maul");
        ch2.setHeight(175);
        ch2.setMass(80);
        ch2.setHairColor("none");
        ch2.setSkinColor("red");
        ch2.setEyeColor("yellow");
        ch2.setBirthYear("54BBY");
        ch2.setGender("male");
        ch2.setHomeWorld("Dathomir");
        ch2.setSpecies("Zabrak");

        List<CharacterDTO> expected = new ArrayList<>(List.of(ch1, ch2));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String responseJson = writer.writeValueAsString(expected);

        MvcResult response = this.mockMvc.perform(get("/" + query))
                .andDo(print()).andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson, response.getResponse().getContentAsString());
    }

}
