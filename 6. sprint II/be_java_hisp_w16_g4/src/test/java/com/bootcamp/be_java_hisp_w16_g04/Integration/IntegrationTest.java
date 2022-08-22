package com.bootcamp.be_java_hisp_w16_g04.Integration;

import com.bootcamp.be_java_hisp_w16_g04.service.ProductService;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class IntegrationTest {

    @Autowired
    private MockMvc mockito;

    @InjectMocks
    ProductService productService;


    @DisplayName("Deberia retornar bad request")
    @Test
    void testPostBadRequest() throws Exception{
        this.mockito.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtilsGenerator.TEST_INTEGRATION_STATUS_BAD_REQUEST))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @DisplayName("Deberia retornar status ok")
    @Test
    void testPromoPostOk() throws Exception{
        this.mockito.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtilsGenerator.TEST_INTEGRATION_STATUS_OK))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Deberia seguir un usuario")
    @Test
    void testFollowOk() throws Exception{

        this.mockito.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",103, 104)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Successful follow-up"))
                .andReturn();
    }
}
