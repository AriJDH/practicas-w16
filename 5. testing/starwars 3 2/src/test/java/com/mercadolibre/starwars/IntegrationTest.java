package com.mercadolibre.starwars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
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

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception{
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);

        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(characterDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                //withDefaultPrettyPrinter lo sacamos paara quitar la identacion.
                .writer().withDefaultPrettyPrinter();
        //String responseCharacterDTOListJson = writer.writeValueAsString(characterDTOList);

        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Luke Skywalker"))
                        .andReturn();

        //assertEquals(responseCharacterDTOListJson, mvcResult.getResponse().getContentAsString());
        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}
