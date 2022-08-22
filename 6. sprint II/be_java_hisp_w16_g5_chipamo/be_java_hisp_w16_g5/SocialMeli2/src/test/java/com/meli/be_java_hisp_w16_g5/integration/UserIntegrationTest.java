package com.meli.be_java_hisp_w16_g5.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.be_java_hisp_w16_g5.controller.UserController;
import com.meli.be_java_hisp_w16_g5.dto.UserDto;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.exceptions.UnknownRequestException;
import com.meli.be_java_hisp_w16_g5.exceptions.UserNotFoundException;
import com.meli.be_java_hisp_w16_g5.repository.UserRepository;
import com.meli.be_java_hisp_w16_g5.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.meli.be_java_hisp_w16_g5.dto.UserFollowsDto;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;


    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @BeforeEach
    public void setUp() {

        List<User> users = new ArrayList<>();
        User user =  UtilTestTools.createCompletedUser("Gae", 1);
        users.add(user);
        users.add(UtilTestTools.createUser("Johannes", 2));
        users.add(UtilTestTools.createUser("Ignacio", 7));
        this.userRepository.save(users);

    }

    @Test
    public void getUserIdGivenIdOneWithOutOrder() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Gae"))
                .andExpect(jsonPath("$.followed[0].user_id").value(3))
                .andExpect(jsonPath("$.followed[0].user_name").value("Sebastian"))
                .andExpect(jsonPath("$.followed[1].user_id").value(5))
                .andExpect(jsonPath("$.followed[1].user_name").value("Simon"))
                .andExpect(jsonPath("$.followed[2].user_id").value(9))
                .andExpect(jsonPath("$.followed[2].user_name").value("Alberto"));

    }

    @Test
    public void getUserIdGivenIdOneWithOrderDesc() throws Exception{

            this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1)
                    .param("order","name_desc"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.user_id").value(1))
                    .andExpect(jsonPath("$.user_name").value("Gae"))
                    .andExpect(jsonPath("$.followed[0].user_id").value(5))
                    .andExpect(jsonPath("$.followed[0].user_name").value("Simon"))
                    .andExpect(jsonPath("$.followed[1].user_id").value(3))
                    .andExpect(jsonPath("$.followed[1].user_name").value("Sebastian"))
                    .andExpect(jsonPath("$.followed[2].user_id").value(9))
                    .andExpect(jsonPath("$.followed[2].user_name").value("Alberto"));

    }
    
    @Test
    public void getUserIdGivenIdOneWithOrderAsc() throws Exception{
            this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1)
                    .param("order","name_asc"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.user_id").value(1))
                    .andExpect(jsonPath("$.user_name").value("Gae"))
                    .andExpect(jsonPath("$.followed[2].user_id").value(5))
                    .andExpect(jsonPath("$.followed[2].user_name").value("Simon"))
                    .andExpect(jsonPath("$.followed[1].user_id").value(3))
                    .andExpect(jsonPath("$.followed[1].user_name").value("Sebastian"))
                    .andExpect(jsonPath("$.followed[0].user_id").value(9))
                    .andExpect(jsonPath("$.followed[0].user_name").value("Alberto"));
    }
 
    // By: Yenny Chipamo Pruebas Integradas
    @Test
    public void setUserFollowSellerTestOutput() throws Exception {
        
        UserFollowsDto payloadDto = new UserFollowsDto();

        String payloadJson = UtilTestTools.generatePayload(payloadDto);

        this.mockMvc.perform(post("/users/1/follow/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.mensaje").value("Usuario: Gae siguiendo a: Johannes"));

    }

    @Test
    public void getUserIdGivenAnIdThrowUserNotFoundException() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",9999)
                .param("order","name_asc"))

                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertTrue(result.getResolvedException() instanceof UserNotFoundException);
                })
                .andExpect(jsonPath("$.mensaje").value("Usuario no encontrado"));

    }

    @Test
    public void getUserIdGivenAnIdThrowUnknownOrderException() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .param("order","name_unknown"))

                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertTrue(result.getResolvedException() instanceof UnknownRequestException);
                })
                .andExpect(jsonPath("$.mensaje").value("Unknown order: name_unknown"));

    }

    @Test
    public void getFollowersWithOutOrder() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("Gae"))
                .andExpect(jsonPath("$.followers[0].user_id").value(2))
                .andExpect(jsonPath("$.followers[0].user_name").value("Johannes"))
                .andExpect(jsonPath("$.followers[1].user_id").value(5))
                .andExpect(jsonPath("$.followers[1].user_name").value("Simon"));

    }

    @Test
    public void getFollowersWithAsc() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1)
            .param("order","name_asc"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.user_id").value(1))
            .andExpect(jsonPath("$.user_name").value("Gae"))
            .andExpect(jsonPath("$.followers[0].user_id").value(2))
            .andExpect(jsonPath("$.followers[0].user_name").value("Johannes"))
            .andExpect(jsonPath("$.followers[1].user_id").value(5))
            .andExpect(jsonPath("$.followers[1].user_name").value("Simon"));

    }

    @Test
    public void getFollowersWithDesc() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1)
            .param("order","name_desc"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.user_id").value(1))
            .andExpect(jsonPath("$.user_name").value("Gae"))
            .andExpect(jsonPath("$.followers[0].user_id").value(5))
            .andExpect(jsonPath("$.followers[0].user_name").value("Simon"))
            .andExpect(jsonPath("$.followers[1].user_id").value(2))
            .andExpect(jsonPath("$.followers[1].user_name").value("Johannes"));

    }

    @Test
    public void getFollowersWithThrowUnknownOrderException() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1)
                .param("order","name_unknown"))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertTrue(result.getResolvedException() instanceof UnknownRequestException);
                })
                .andExpect(jsonPath("$.mensaje").value("Unknown order: name_unknown"));

    }

    @Test
    public void getFollowersWithUserNotFoundException() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",9999))
              .andDo(print())
              .andExpect(content().contentType(MediaType.APPLICATION_JSON))
              .andExpect(status().isBadRequest())
              .andExpect(result -> {
                  assertTrue(result.getResolvedException() instanceof UserNotFoundException);
              })
              .andExpect(jsonPath("$.mensaje").value("Usuario no encontrado"));

    }





    @Test
    public void userCountFollowersTest() throws UserNotFoundException {
        UserDto userDto= new UserDto(1,"Sebastian",10);
        when(userService.getCountFollows(1)).thenReturn(userDto);
        userController.getFollowersCount(1);
        verify(userService, atLeast(1)).getCountFollows(1);
        assertThat(userDto.getFollowersCount()==userController.getFollowersCount(1).getBody().getFollowersCount());

    }


    @Test
    public  void userCountFollowerControllerTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1));

    }


    @Test
    void unfollowControllerTest() throws UserNotFoundException {
        UserFollowsDto userFollowsDtoExpect = new UserFollowsDto("Todo ok");
        when(userService.setUnfollowUser(1,2)).thenReturn(userFollowsDtoExpect);
        userController.setUnfollowSeller(1,2);
        verify(userService,atLeastOnce()).setUnfollowUser(1,2);
        assertThat(userFollowsDtoExpect.getMensaje().equalsIgnoreCase(userController.setUnfollowSeller(1,2).getBody().toString()));
    }


    @Test
    void unfollowControllerIntegrationTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("Todo ok"));
    }

    @Test
    void unfollowControllerIntegrationNullTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,4693))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    public void setUserUnfollowSellerTestOutputOk() throws Exception {//YENNY CHIPAMO UnfollowSeller OK BONUS

        UserFollowsDto payloadDto = new UserFollowsDto();

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/1/unfollow/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensaje").value("Todo ok"))
        ;

    }
}
