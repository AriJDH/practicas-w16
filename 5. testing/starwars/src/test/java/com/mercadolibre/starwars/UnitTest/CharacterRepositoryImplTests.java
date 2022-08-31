package com.mercadolibre.starwars.UnitTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTests {

  @Mock
  CharacterRepositoryImpl characterRepository;

  @BeforeEach
  public void loadDataTest() {
    characterRepository.loadDataBase();
  }

  @Test
  public void findAllByNameContainsTest() {

    List<CharacterDTO> characterDTOList = characterRepository.findAllByNameContains("Luke");

    Assertions.assertNotNull(characterDTOList);
  }
}
