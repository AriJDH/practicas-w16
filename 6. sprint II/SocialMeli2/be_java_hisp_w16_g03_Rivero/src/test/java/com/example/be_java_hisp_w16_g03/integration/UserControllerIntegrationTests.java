package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.*;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.be_java_hisp_w16_g03.utils.MocksPost.*;
import static com.example.be_java_hisp_w16_g03.utils.MocksUser.createSeller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void createUserTest() throws  Exception{
        UserDTO userDTO1=new UserDTO(7,"jorge");
        UserDTO userDTO2=new UserDTO(8,"pedro");
        UserDTO userDTO3=new UserDTO(9,"felipe");
        List<UserDTO> listUserDTO= Arrays.asList(userDTO1,userDTO2,userDTO3);
        UserDTO user1 = new UserDTO (1,"pablo");
        UserDTO user2 = new UserDTO (2,"emanuel");
        UserDTO user3 = new UserDTO (3,"joaco");
        UserDTO user4 = new UserDTO (4,"lucas");
        UserDTO user5 = new UserDTO (5,"agustin");
        UserDTO user6 = new UserDTO (6,"ivana");
        List<UserDTO> response=Arrays.asList(user1,user2,user3,user4,user5,user6,userDTO1,userDTO2,userDTO3);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule()).writer().withDefaultPrettyPrinter();

        String payloadjson = writer.writeValueAsString(listUserDTO);
        String responseJson = writer.writeValueAsString(response);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadjson))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));

    }
    @Test
    public void createUserExistsErrorTest() throws  Exception{
        UserDTO userDTO1=new UserDTO(1,"jorge");
        UserDTO userDTO2=new UserDTO(2,"pedro");
        UserDTO userDTO3=new UserDTO(3,"felipe");
        List<UserDTO> listUserDTO= Arrays.asList(userDTO1,userDTO2,userDTO3);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String payloadjson = writer.writeValueAsString(listUserDTO);
        //String responseJson = writer.writeValueAsString(response);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadjson))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> result.getResolvedException());

    }

    @Test
    public void getCountFollowers() throws Exception {

        FollowerCountDTO response= new FollowerCountDTO();
        response.setFollowersCount(0);
        response.setUserId(1);
        response.setUserName("pablo");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(response);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/"+1+"/followers/count"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }
    @Test
    public void followUserErrorAlreadyFollowersTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/"+1+"/follow/"+6))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> result.getResolvedException());

    }
    @Test
    public void followUserErrorAlreadyFollowersExceptionTest() throws Exception {
        ExceptionApiDTO exceptionApiDTO=new ExceptionApiDTO();
        exceptionApiDTO.setTitle("Error");
        exceptionApiDTO.setMessage("El usuario con el id: 1 ya es seguidor de : 6");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(exceptionApiDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/"+1+"/follow/"+6))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));

    }

    @Test
    public void followUserIsNotSellerTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/"+1+"/follow/"+3))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> result.getResolvedException());

    }

    @Test
    public void unfollowUserNotExistTest() throws  Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/"+2+"/unfollow/"+5))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> result.getResolvedException());
    }
    @Test
    public void unfollowUserExistTest() throws  Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/"+1+"/unfollow/"+2))
                .andDo(print()).andExpect(status().isOk());
    }
   /* @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<FollowedsDTO> getFollowedUsers(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getFollowedUsers(userId, order), HttpStatus.OK);
    }*/

    @Test
    public void getFollowedUserASCTest()throws Exception{

        FollowedsDTO followedsDTO=new FollowedsDTO();
        followedsDTO.setFollowed(new ArrayList<>());
        followedsDTO.setUserName("agustin");
        followedsDTO.setUserId(5);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(followedsDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/"+5+"/followed/list?order=name_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }


    @Test
    public void getFollowersUserASCTest()throws Exception{

        FollowersDTO followersDTO=new FollowersDTO();
        followersDTO.setFollowers(new ArrayList<>());
        followersDTO.setUserName("agustin");
        followersDTO.setUserId(5);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(followersDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/"+5+"/followers/list?order=name_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

}
