package com.bootcamp.be_java_hisp_w16_g04.integration;

import com.bootcamp.be_java_hisp_w16_g04.service.ProductService;
import com.bootcamp.be_java_hisp_w16_g04.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestExample {

  @Autowired
  private MockMvc mockito;

  @InjectMocks
  ProductService productService;




  @DisplayName("Debe dar bad request")
  @Test
  void test() throws Exception{
    MvcResult mvcProductResult = this.mockito.perform(MockMvcRequestBuilders.post("/products/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtilsGenerator.TEST_INTEGRATION_STATUS_BAD_REQUEST))
            .andDo(print())
            .andExpect(status().isBadRequest()).andReturn();

    Assertions.assertEquals("application/json", mvcProductResult.getResponse().getContentType());
  }

  @DisplayName("Debe contar la cantidad de seguidores")
  @Test
  void test2() throws Exception{
    String variable = "{" + "\"user_id\":100," + "\"user_name\":\"Andres Roa\"," + "\"followers_count\":4" + "}";

    MvcResult mvcProductResult = this.mockito.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",100)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print())
            .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(4)).andReturn();

    Assertions.assertEquals(variable, mvcProductResult.getResponse().getContentAsString());

  }

  @DisplayName("Debe contar la cantidad de seguidores")
  @Test
  void test3() throws Exception{

    MvcResult mvcProductResult = this.mockito.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",100)
            .contentType(MediaType.APPLICATION_JSON))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(4)).andReturn();

    //Assertions.assertEquals(variable, mvcProductResult.getResponse().getContentAsString());



  }
}