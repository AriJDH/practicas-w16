package com.mercadolibre.linktracker;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class LinkTrackerApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  void contextLoad() throws Exception {
    String request = "{\"link\": \"https://www.digitalhouse.com\"}";
    this.mockMvc.perform(
        post("/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request));
  }

  //Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON con el linkId para utilizar en la redireccion.
  @Test
  void createLink() throws Exception {
    String request = "{\"link\": \"https://www.mercadolibre.com\"}";
    this.mockMvc.perform(
        post("/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.link").exists())
        .andExpect(jsonPath("$.linkId").exists());
  }

  //Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido devolver 404.
  @Test
  void successRedirect() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/link/0"))
        .andDo(print())
        .andExpect(status().is3xxRedirection());
  }

  @Test
  void invalidRedirect() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/link/100"))
        .andDo(print())
        .andExpect(status().isNotFound());
  }

  //Estadísticas por link: Enpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} ) tiene devuelve la estadística de cantidad de veces que se redireccionó.
  @Test
  void getMetrics() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/metrics/0"))
        .andDo(print())
        .andExpect(jsonPath("$.count").exists());
  }

  //Invalidate link: Endpoint POST para invalidar un link ((ej: http://localhost:8080/invalidate/{linkID}
  @Test
  void invalidate() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.post("/invalidate/1"))
        .andDo(print())
        .andExpect(status().isOk());
  }

  //Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la redirección.
  @Test
  void createLinkWithPassword() throws Exception {
    String request = "{\"link\": \"https://www.google.com\", \"password\": \"123456\"}";
    MvcResult mvcResult = this.mockMvc.perform(
        post("/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(request))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.link").exists())
        .andExpect(jsonPath("$.linkId").exists()).andReturn();

    Integer id = JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.linkId");

    this.mockMvc.perform(MockMvcRequestBuilders.get("/link/" + id + "?password=123456"))
        .andDo(print())
        .andExpect(status().is3xxRedirection());

    this.mockMvc.perform(MockMvcRequestBuilders.get("/link/" + id + "?password=23874203974"))
        .andDo(print())
        .andExpect(status().isNotFound());
  }


}
