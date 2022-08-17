package com.mercadolibre.starwars.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findTest() throws Exception {

        var res = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "Luke"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andReturn();

        assertNotNull(res);
    }

    @Test
    void notFoundTest() throws Exception {

        var res = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", "asdasdasd"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals("application/json", res.getResponse().getContentType());
        assertEquals("[]", res.getResponse().getContentAsString());
    }
}
