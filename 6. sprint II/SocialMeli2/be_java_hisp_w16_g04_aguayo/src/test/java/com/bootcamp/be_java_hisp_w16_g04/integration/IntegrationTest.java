package com.bootcamp.be_java_hisp_w16_g04.integration;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Creación satisfactoria de una publicación")
    void createPublicacionTestOK() throws Exception {
        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtilsGenerator.publicationDTO))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Success"))
                .andExpect(jsonPath("$.message").value("All ok"));
    }

    @Test
    @DisplayName("Creacion de una bad publicación error validaciones")
    void createPublicationTestBad() throws Exception {
        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtilsGenerator.badPublicationDTO))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.userId").value("El ID deber ser mayor a cero."));
    }

    @Test
    @DisplayName("Cuenta el total de seguidores de un usuario")
    void totalFollowersCountTest() throws Exception {
        this.mockMvc.perform(get("/users/{userId}/followers/count", 100))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(4));
    }

    @Test
    @DisplayName("No dejar seguir a usuario inexistente")
    void followNonExistentUserTest() throws Exception {
        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 110, 104))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User Not Found with User Id: 110"));
    }

    @Test
    @DisplayName("Verifica que el seguir esté funcionando correctamente")
    void FollowTestOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",103, 104)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Successful follow-up"))
                .andReturn();
    }
}
