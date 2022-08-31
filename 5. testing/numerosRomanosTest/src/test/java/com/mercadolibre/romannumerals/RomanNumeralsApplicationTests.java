package com.mercadolibre.romannumerals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RomanNumeralsApplicationTests {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void oneShouldBeI() throws Exception {
    performTest("1", "I");
  }

  @Test
  void tenShouldBeX() throws Exception {
    performTest("10", "X");
  }

  @Test
  void sevenShouldBeVII() throws Exception {
    performTest("7", "VII");
  }

  @Test
  void fifteenShouldBeXV() throws Exception {
    performTest("15", "XV");
  }

  @Test
  private void performTest(String number, String roman) throws Exception {

    this.mockMvc.perform(
            MockMvcRequestBuilders.get("/{number}", number))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(content().contentType("application/json"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(roman)));
  }
}
