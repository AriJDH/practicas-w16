package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.PostLastTwoWeeksDto;
import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli2.dto.ProductDto;

import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.repository.PostRepository;
import com.example.socialmeli2.repository.UserRepository;
import com.example.socialmeli2.service.IUserService;
import com.example.socialmeli2.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private IRepository<User> userRepository;
    @Autowired
    private IRepository<Post> postRepository;
    @Autowired
    private IUserService userService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void reset() {
        // users
        ((UserRepository) userRepository).clear();

        User marcos = Util.getUser(1, "Marcos Galperin");
        User gonzalo = Util.getUser(2, "Gonzalo Nahuel Di Pierro");
        User pamela = Util.getUser(3, "Pamela Pereyra");

        userRepository.add(marcos);
        userRepository.add(gonzalo);
        userRepository.add(pamela);

        // posts
        ((PostRepository) postRepository).clear();

        postRepository.add(Util.getPost(1, marcos.getUserId(), Util.getProduct(1, "Vehiculo MeLi"), LocalDate.now()));
        postRepository.add(Util.getPost(2, marcos.getUserId(), Util.getProduct(2, "Gafas MeLi"), LocalDate.now().minusDays(7)));
        postRepository.add(Util.getPost(3, marcos.getUserId(), Util.getProduct(3, "Taza MeLi"), LocalDate.now().minusDays(30)));
        postRepository.add(Util.getPost(4, marcos.getUserId(), Util.getProduct(4, "Mousepad MeLi"), LocalDate.now().minusDays(60)));
        postRepository.add(Util.getPost(5, marcos.getUserId(), Util.getProduct(5, "Termo MeLi"), LocalDate.now().minusDays(3)));
    }

    @Test
    @DisplayName("STATUS_OK: agregar un Post")
    public void addPostTest() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setUserId(2);
        postDto.setDate(LocalDate.of(2022, 8, 1));
        postDto.setProduct(new ProductDto(1, "Microfono", "Gamer", "HyperX", "Rojo", "Ultimo modelo"));
        postDto.setCategory(1);
        postDto.setPrice(10000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadPostDtoJson = writer.writeValueAsString(postDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadPostDtoJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("STATUS_OK: obtener la lista de los Post de las últimas dos semanas que realizó un usuario al cual sigue otro usuario -- ASC")
    public void getFollowedPostLastTwoWeeksByOrderAscTest() throws Exception {
        userService.addFollower(2, 1);

        PostListLastTwoWeeksDto postListLastTwoWeeksDto = new PostListLastTwoWeeksDto();
        postListLastTwoWeeksDto.setUserId(2);
        postListLastTwoWeeksDto.setPosts(Arrays.asList(
                new PostLastTwoWeeksDto(2, 1, LocalDate.now().minusDays(7), new ProductDto(2, "Gafas MeLi", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(5, 1, LocalDate.now().minusDays(3), new ProductDto(5, "Termo MeLi", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(1, 1, LocalDate.now(), new ProductDto(1, "Vehiculo MeLi", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responsePostListLastTwoWeeksDtoJson = writer.writeValueAsString(postListLastTwoWeeksDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "2")
                        .param("order", "date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responsePostListLastTwoWeeksDtoJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("STATUS_OK: obtener la lista de los Post de las últimas dos semanas que realizó un usuario al cual sigue otro usuario -- DESC")
    public void getFollowedPostLastTwoWeeksByOrderdescTest() throws Exception {
        userService.addFollower(2, 1);

        PostListLastTwoWeeksDto postListLastTwoWeeksDto = new PostListLastTwoWeeksDto();
        postListLastTwoWeeksDto.setUserId(2);
        postListLastTwoWeeksDto.setPosts(Arrays.asList(
                new PostLastTwoWeeksDto(1, 1, LocalDate.now(), new ProductDto(1, "Vehiculo MeLi", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(5, 1, LocalDate.now().minusDays(3), new ProductDto(5, "Termo MeLi", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(2, 1, LocalDate.now().minusDays(7), new ProductDto(2, "Gafas MeLi", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responsePostListLastTwoWeeksDtoJson = writer.writeValueAsString(postListLastTwoWeeksDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "2")
                        .param("order", "date_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responsePostListLastTwoWeeksDtoJson, mvcResult.getResponse().getContentAsString());
    }
}
