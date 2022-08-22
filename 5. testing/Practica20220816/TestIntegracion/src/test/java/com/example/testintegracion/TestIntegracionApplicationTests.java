package com.example.testintegracion;

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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestIntegracionApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception{
        MvcResult mvcResult= this.mockMvc.perform(MockMvcRequestBuilders.get("/sayHello"))
                // perform: simula un llamado a un endpoint. Permite definir a que tipo de meotodo llamo y a que endpoint
                .andDo(print())
                // print: muestra tanto request como response
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Hello World"))
                //Expect es como ansserd como las pruebas unitaria
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void testHelloDani() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/sayHello/{name}", "Dani"))
                // Se agregan despues del endpoint tantos valores variables como parametros haya
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Hello Dani"))
                .andReturn();
    }

}
