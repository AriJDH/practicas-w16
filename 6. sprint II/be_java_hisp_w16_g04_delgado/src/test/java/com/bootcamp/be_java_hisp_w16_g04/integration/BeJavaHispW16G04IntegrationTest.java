package com.bootcamp.be_java_hisp_w16_g04.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BeJavaHispW16G04IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPost() throws Exception {
        String payloadJson = "" +
                "{" +
                "\"user_id\": 104, \n" +
                "\"date\": \"19-08-2022\",\n" +
                "\"product\": {\n" +
                "\"product_id\": 2," +
                "\"product_name\": \"PC\",\n" +
                "\"type\": \"Portatil\",\n" +
                "\"brand\": \"HP\", \n" +
                "\"color\": \"gris\",\n" +
                "\"notes\": \"**ninguna\" \n" +
                "},\n" +
                "\"category\": 200,\n" +
                "\"price\": 1500.50 \n" +
                "}";

        MvcResult mvcProductResult = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest()).andReturn();

        Assertions.assertEquals("application/json", mvcProductResult.getResponse().getContentType());
    }

    @Test
    void followUserTest2() throws Exception {
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 101,104))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Successful follow-up"));
    }




}