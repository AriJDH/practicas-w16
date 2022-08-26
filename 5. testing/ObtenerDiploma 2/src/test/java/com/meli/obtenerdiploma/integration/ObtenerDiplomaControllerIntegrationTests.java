package com.meli.obtenerdiploma.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testObtenerDiplomaOutput() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 6L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(6L));
    }

    @Test
    public void testObtenerDiplomaExceptionIdNotFound() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 777L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"));
    }
}
