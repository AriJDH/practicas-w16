package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostWithIdDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addPost() throws  Exception{
        PostDTO postDTO=new PostDTO();
        postDTO.setUserId(5);
        postDTO.setDate(LocalDate.of(2022,8,14));
        postDTO.setCategory(4);
        postDTO.setPrice(2140d);
        postDTO.setProduct(new ProductDTO(1,"Cabeza","Extremo","Maximo","Rojo","vacio"));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String payloadjson = writer.writeValueAsString(postDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadjson))
                .andDo(print()).andExpect(status().isOk());

    }
    /*@GetMapping("/products/followed/{userId}/list")
    public ResponseEntity<PostsDTO> getLatestPostsOrderedByUserId(@PathVariable Integer userId, @RequestParam(required = false) String order) {
        return new ResponseEntity<>(service.getLatestPostsOrderedByUserId(userId, order), HttpStatus.OK);
    }*/
    @Test
    public void getLatestPostsOrderedASCByUserIdTest() throws Exception{
        PostDTO postDTO=new PostDTO();
        postDTO.setUserId(5);
        postDTO.setDate(LocalDate.of(2022,8,14));
        postDTO.setCategory(4);
        postDTO.setPrice(2140d);
        postDTO.setProduct(new ProductDTO(1,"Cabeza","Extremo"
                ,"Maximo","Rojo","vacio"));
        List<PostWithIdDTO> listPosts=Arrays.asList(Mapper.postToPostWithIdDto(Mapper.postDtoToEntity(postDTO)));
        listPosts.get(0).setPostId(0);
        List<PostDTO> listPost=Arrays.asList(postDTO);
        PostsDTO postsDTO=new PostsDTO();
        postsDTO.setUserId(1);
        postsDTO.setPosts(listPosts);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(postsDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/"+1+"/list"+"?order=date_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }



}
