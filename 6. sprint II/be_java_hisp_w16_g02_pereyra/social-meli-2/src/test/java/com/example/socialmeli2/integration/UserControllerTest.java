package com.example.socialmeli2.integration;


import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private IUserService userService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addFollowerTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void addFollowerNotExistUserTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "10", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario con codigo 10 no existe."))
                .andReturn();;
    }
    @Test
    public void AddFollowerBadRequestTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "1"))
                .andDo((print()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no puede seguirse a si mismo."))
                .andReturn();
    }

    @Test
    @Disabled("Se deja de esta manera hasta encontrar motivo de inicialización de la base de datos")
    public void getFollowersCountByUserIdTest() throws Exception {
        userService.addFollower(2, 1);
        userService.addFollower(3, 1);

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(1);
        userFollowersCountDto.setUserName("gonza");
        userFollowersCountDto.setFollowersCount(2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseUserFollowerCountDtoJson = writer.writeValueAsString(userFollowersCountDto);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseUserFollowerCountDtoJson));
    }

}