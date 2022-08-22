package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.PostDto;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        ((UserRepository) userRepository).clear();
        User gonza = Util.getUser(1, "gonza");
        User erika = Util.getUser(2, "erika");
        User pame = Util.getUser(3, "pame");
        User mateo = Util.getUser(4, "mateo");
        User sabrina = Util.getUser(5, "sabrina");
        User claudio = Util.getUser(6, "claudio");
        userRepository.add(gonza);
        userRepository.add(erika);
        userRepository.add(pame);
        userRepository.add(mateo);
        userRepository.add(sabrina);
        userRepository.add(claudio);

        ((PostRepository) postRepository).clear();
        postRepository.add(Util.getPost(1, sabrina.getUserId(), Util.getProduct(1, "Garbanzos"), LocalDate.now().minusDays(12)));
        postRepository.add(Util.getPost(2, sabrina.getUserId(), Util.getProduct(2, "Mayonesa"), LocalDate.now().minusDays(10)));
        postRepository.add(Util.getPost(3, sabrina.getUserId(), Util.getProduct(3, "Hamburguesas"), LocalDate.now()));
        postRepository.add(Util.getPost(5, sabrina.getUserId(), Util.getProduct(5, "Cafe"), LocalDate.of(2022, 8, 19)));

    }

    @Test
    @DisplayName("Agrego un Post")
    public void testAddPost() throws Exception{
        PostDto postDto = new PostDto();
        postDto.setUserId(1);
        postDto.setDate(LocalDate.of(2022, 8, 19));
        postDto.setProduct(new ProductDto(5, "Cafe", "Late", "Leche de Almendras", "marron", "Ideal para consumir en cualquier momento del dia"));
        postDto.setCategory(10);
        postDto.setPrice(475.0);

        // Conversion de Dto a Json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJsonPostDto = writer.writeValueAsString(postDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJsonPostDto))
                .andDo(print())
                .andExpect(status().isOk());
    }
}