package com.bootcamp.be_java_hisp_w16_g10.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void UserFollowRouteShouldRaiseAnErrorIfIsTheSameUser() throws Exception {
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/users/1/follow/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Cannot follow yourself"));
    }

}
