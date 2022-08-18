package com.mercadolibre.romannumerals.unitTest;

import com.mercadolibre.romannumerals.RomanNumeralsRestController;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumersRestControllerUnitTest {

   @Autowired
   RomanNumeralsRestController controller;

   @Test
   void shouldReturn_I_whenIntegerEquals1() {
      String result = controller.toRoman(1);

      Assertions.assertThat(result.equals("I")).isTrue();

   }

   @Test
   void shouldReturn_III_whenIntegerEquals3() {
      String result = controller.toRoman(3);

      Assertions.assertThat(result.equals("III")).isTrue();

   }

   @Test
   void shouldReturn_X_whenIntegerEquals10() {
      String result = controller.toRoman(10);

      Assertions.assertThat(result.equals("X")).isTrue();

   }
}
