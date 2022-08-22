package com.bootcamp.be_java_hisp_w16_g04.integration;

import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("create a successful publication")
  void createPublicacionOkTest() throws Exception {

    this.mockMvc.perform(post("/products/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtilsGenerator.publicationDTO))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.title").value("Success"))
        .andExpect(jsonPath("$.message").value("All ok"));
  }

  @Test
  @DisplayName("create a failed publication for validations")
  void createBadPublicationTest() throws Exception {
    this.mockMvc.perform(post("/products/post")
        .contentType(MediaType.APPLICATION_JSON)
        .content(TestUtilsGenerator.badPublicationDTO))
        .andDo(print()).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.userId").value("El ID deber ser mayor a cero."));
  }

  @Test
  @DisplayName("Getting the list of products of the vendors a user follows without sending the order")
  void getListOfProductsWithoutOrderTest() throws Exception {
    this.mockMvc.perform(get("/products/followed/{userId}/list", 100))
        .andDo(print()).andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Failed to order date"));
  }

  @Test
  @DisplayName("Obtaining the list of products from vendors that a person follows correctly.")
  void getProductListTest() throws Exception {
    this.mockMvc.perform(get("/products/followed/{userId}/list", 106)
            .param("order","date_asc"))
        .andDo(print()).andExpect(status().isOk());
  }
}
