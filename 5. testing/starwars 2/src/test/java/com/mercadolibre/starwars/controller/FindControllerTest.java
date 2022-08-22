package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findTest() {
        String name = "Luke";
        List<CharacterDTO> characterDTOS = Utils.findAllByNameContains(name);
        when(service.find(name)).thenReturn(characterDTOS);

        List<CharacterDTO> characterDTOSController = controller.find(name);

        verify(service, atLeastOnce()).find(name);
        assertEquals(characterDTOS, characterDTOSController);
    }

    @Test
    public void findCharacterTest() throws Exception {
        String name = "Luke";
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/{characterName}", name))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").isString())
                        .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void findSimilarCharacterTest() throws Exception {
        String name = "Darth";
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/{characterName}", name))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(jsonPath("$", hasSize(2)))
                        .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}
