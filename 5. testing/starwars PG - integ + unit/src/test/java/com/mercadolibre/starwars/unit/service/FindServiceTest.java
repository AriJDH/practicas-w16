package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    CharacterDTO mockedCharacter;

    @BeforeEach
    void init() {
        mockedCharacter = new CharacterDTO();
        mockedCharacter.setName("Ricardito Mocked");

        when(characterRepository.findAllByNameContains(anyString()))
                .thenReturn(new ArrayList<>());

        when(characterRepository.findAllByNameContains("Ricardito"))
                .thenReturn(Arrays.asList(mockedCharacter));
    }

    @Test
    void searchByName() {
        List<CharacterDTO> searchResult = findService.find("Ricardito");

        Assertions.assertEquals(1, searchResult.size());
        Assertions.assertTrue(searchResult.get(0).getName() == mockedCharacter.getName());
        verify(characterRepository, atLeastOnce()).findAllByNameContains(anyString());
    }

}
