package com.mercadolibre.starwars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

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
    public void findTest() throws Exception {
        CharacterDTO lukeSkywalker = new CharacterDTO();
        lukeSkywalker.setName("Luke Skywalker");
        lukeSkywalker.setHair_color("blond");
        lukeSkywalker.setSkin_color("fair");
        lukeSkywalker.setEye_color("blue");
        lukeSkywalker.setBirth_year("19BBY");
        lukeSkywalker.setGender("male");
        lukeSkywalker.setHomeworld("Tatooine");
        lukeSkywalker.setSpecies("Human");
        lukeSkywalker.setHeight(172);
        lukeSkywalker.setMass(77);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, false)
                .writer().withDefaultPrettyPrinter();
        String responseCharacterDTOListJson = writer.writeValueAsString(Arrays.asList(lukeSkywalker));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseCharacterDTOListJson));
    }

    @Test
    public void findWithTwoFoundsTest() throws Exception {
        CharacterDTO darthVader = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthVader.setHair_color("none");
        darthVader.setSkin_color("white");
        darthVader.setEye_color("yellow");
        darthVader.setBirth_year("41.9BBY");
        darthVader.setGender("male");
        darthVader.setHomeworld("Tatooine");
        darthVader.setSpecies("Human");
        darthVader.setHeight(202);
        darthVader.setMass(136);

        CharacterDTO darthMaul = new CharacterDTO();
        darthMaul.setName("Darth Maul");
        darthMaul.setHair_color("none");
        darthMaul.setSkin_color("red");
        darthMaul.setEye_color("yellow");
        darthMaul.setBirth_year("54BBY");
        darthMaul.setGender("male");
        darthMaul.setHomeworld("Dathomir");
        darthMaul.setSpecies("Zabrak");
        darthMaul.setHeight(175);
        darthMaul.setMass(80);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.INDENT_OUTPUT, false)
                .writer();
        String responseCharacterDTOListJson = writer.writeValueAsString(Arrays.asList(darthVader, darthMaul));

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Darth"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseCharacterDTOListJson, mvcResult.getResponse().getContentAsString());
    }
}
