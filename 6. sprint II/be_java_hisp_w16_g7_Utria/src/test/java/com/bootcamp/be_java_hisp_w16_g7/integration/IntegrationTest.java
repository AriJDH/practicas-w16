package com.bootcamp.be_java_hisp_w16_g7.integration;

import com.bootcamp.be_java_hisp_w16_g7.dto.FollowersCountDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Debe dar bad request -> La fecha no puede estar vacía.")
        @Test
        public void createPostBadRequest() throws Exception {

            mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{    \"user_id\": \"1111\",\n" +
                            "    \"product\": {\n" +
                            "        \"product_id\": 23232,\n" +
                            "        \"product_name\": \"Mouse\",\n" +
                            "        \"type\": \"Tech\",\n" +
                            "        \"brand\": \"Apple\",\n" +
                            "        \"color\": \"White\",\n" +
                            "        \"notes\": \"new\"\n" +
                            "    },\n" +
                            "    \"category\": \"120\",\n" +
                            "    \"price\": 2000" +
                            "}"))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.status").value("BAD_REQUEST"));
        }

        @DisplayName("El usuario no es vendedor")
        @Test
        public void shouldReturnUserIsNotSeller() throws Exception {

            this.mockMvc
                    .perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 4444))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.message").value("User 4444 is not seller"));

        }

}