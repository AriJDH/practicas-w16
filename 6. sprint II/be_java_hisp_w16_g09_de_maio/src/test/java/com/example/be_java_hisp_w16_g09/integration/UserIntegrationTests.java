package com.example.be_java_hisp_w16_g09.integration;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.ProductDto;
import com.example.be_java_hisp_w16_g09.dto.UserFollowedDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTests {

    @Autowired
    private MockMvc application;

    private ObjectWriter objectWriter;

    @BeforeEach
    void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("US0004 - Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)")
    void shouldGetUsersThatAreFollowedByAnUser() throws Exception {
        var userId = 1;
        var userToFollowId = 4;

        application
                .perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userToFollowId))
                .andExpect(status().isOk());

        var response =
                application.perform(get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        var result = new ObjectMapper().readValue(response.getResponse().getContentAsString(), UserFollowedDto.class);

        Assertions.assertThat(result.getUserId()).isEqualTo(userId);
        Assertions.assertThat(result.getFollowing().stream().anyMatch(followed -> followed.getUserId() == userToFollowId)).isTrue();
    }

    @Test
    @DisplayName("US0007 - Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.")
    void shouldAnUserUnfollowAFollowedUser() throws Exception {
        int followerId = 1;
        int followedId = 2;

        var response =
                application.perform(
                        post("/users/{userId}/unfollow/{userIdToUnfollow}", followerId, followedId))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andReturn();

        var parsedMessage = new ObjectMapper().readValue(response.getResponse().getContentAsString(), MessageDto.class);

        var expectedMessage = new MessageDto("User "+followerId+" unfollow "+followedId);

        Assertions.assertThat(parsedMessage).isEqualTo(expectedMessage);
    }

}
