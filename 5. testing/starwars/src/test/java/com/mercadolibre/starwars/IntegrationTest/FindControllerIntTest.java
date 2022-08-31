package com.mercadolibre.starwars.IntegrationTest;

import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:starwars_characters.json")
@AutoConfigureMockMvc
public class FindControllerIntTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  CharacterRepository characterRepository;

  @BeforeEach
  public void setUp() {
    characterRepository.loadDataBase();
  }

  @Test
  public void findTest() throws Exception {

    this.mockMvc.perform(
            MockMvcRequestBuilders.get("/{query}", "Luke"))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(content().contentType("application/json"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.[0].name").value("Luke Skywalker"));
  }
}
