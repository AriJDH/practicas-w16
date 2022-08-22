package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.UserRepository;
import com.example.be_java_hisp_w16_g03.utils.initUsers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static com.example.be_java_hisp_w16_g03.utils.MocksUser.createUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class initDataControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;
    User user;

    @Autowired
    UserRepository repository;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @BeforeEach
    public void beforEach() {

        user = createUser();

        this.repository.setUsers(initUsers.initUserList());
    }

    @Test
    public void createUserExistsException() throws Exception{

        List<UserDTO> payloadDTO = List.of(new UserDTO(1, "User1"));
        ExceptionApiDTO expectedResponseDTO = new ExceptionApiDTO("Not Found", "Ya tenemos un usuario con el id : 1");

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(post("/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

}
