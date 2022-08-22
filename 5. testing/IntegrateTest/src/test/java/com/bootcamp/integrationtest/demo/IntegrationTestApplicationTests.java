package com.bootcamp.integrationtest.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTestApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads()throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/sayHello"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();
    }
    @Test
    void testHelloOutput()throws Exception
    {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sayHello/{name}", "Aldo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello Aldo"));
    }

}
