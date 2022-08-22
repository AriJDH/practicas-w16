package com.mercadolibre.starwars.testintegracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test de integración método find del FindController")
    public void findTest() throws Exception{

        List<CharacterDTO> listExpected = new ArrayList<>();

        CharacterDTO characterDTOExpected = new CharacterDTO();
        characterDTOExpected.setName("Han Solo");
        characterDTOExpected.setBirth_year("29BBY");
        characterDTOExpected.setGender("male");
        characterDTOExpected.setEye_color("brown");
        characterDTOExpected.setMass(80);
        characterDTOExpected.setSkin_color("fair");
        characterDTOExpected.setHeight(180);
        characterDTOExpected.setSpecies("Human");
        characterDTOExpected.setHair_color("brown");
        characterDTOExpected.setHomeworld("Corellia");

        listExpected.add(characterDTOExpected);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseExpected = writer.writeValueAsString(listExpected);

        MvcResult mvcResult = this.mockMvc.perform(get("/{query}", "Han Solo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseExpected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("Nombre vacío - Test de integración")
    public void findEmptyNameTest() throws Exception{

        int responseExpected = 404;

        MvcResult mvcResult = this.mockMvc.perform(get("/{query}", ""))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        Assertions.assertEquals(responseExpected, mvcResult.getResponse().getStatus());


    }

}
