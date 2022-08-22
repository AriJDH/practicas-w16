package com.bootcamp.be_java_hisp_w16_g04.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("following a user correctly")
  void followUser() throws Exception {
    this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 103, 104))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Successful follow-up"));
  }

  @Test
  @DisplayName("Following a user that does not exist")
  void followNonExistentUserTest() throws Exception {
    this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 110, 104))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("User Not Found with User Id: 110"));
  }

  @Test
  @DisplayName("Unfollow a user correctly")
  void unfollowUserTest() throws Exception {
    this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 106, 104))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Unfollow successful"));
  }

  @Test
  @DisplayName("Unfollow a user who does not exist")
  void unfollowNonExistentUserTest() throws Exception {
    this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 110, 104))
        .andDo(print())
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("User Not Found with User Id: 110"));
  }

  @Test
  @DisplayName("Get the total number of followers of a user")
  void totalFollowersCountTest() throws Exception {
    this.mockMvc.perform(get("/users/{userId}/followers/count", 100))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.followers_count").value(4));
  }
}
