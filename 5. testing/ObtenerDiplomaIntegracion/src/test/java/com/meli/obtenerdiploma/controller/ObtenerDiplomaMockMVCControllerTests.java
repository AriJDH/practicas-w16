package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.xml.transform.Result;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaMockMVCControllerTests {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  IObtenerDiplomaService service;

  @InjectMocks
  ObtenerDiplomaController controller;

  @Test
  public void testAnalyzeScoresWithAnExistingStudent() throws Exception {
    MvcResult mvcResult =
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
            .andReturn();

    Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
  }

  @Test
  public void testAnalyzeScoresWithAnNonExistingStudent() throws Exception {
    MvcResult mvcResult =
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 9000)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNotFound())
            .andExpect(result -> Assertions.assertEquals("El alumno con Id 9000 no se encuetra registrado.", result.getResolvedException().getMessage()))
            .andReturn();

    Assertions.assertEquals("application/json", mvcResult.getResponse().getContentAsString());
  }
}
