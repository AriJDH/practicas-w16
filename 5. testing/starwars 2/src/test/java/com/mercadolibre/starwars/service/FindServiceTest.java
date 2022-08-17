package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepositoryImpl characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findTest() {
        String name = "Luke";
        List<CharacterDTO> charactersDTO = Utils.findAllByNameContains(name);
        when(characterRepository.findAllByNameContains(name)).thenReturn(charactersDTO);
        Assertions.assertSame(findService.find(name), charactersDTO);
    }

    @Test
    public void findTestEmptyName() {
        String name = "";
        List<CharacterDTO> charactersDTO = Utils.findAllByNameContains(name);
        when(characterRepository.findAllByNameContains(name)).thenReturn(charactersDTO);
        Assertions.assertSame(findService.find(name), charactersDTO);
    }

    @Test
    public void findTestNonExistingName() {
        String name = "Harry Potter";
        List<CharacterDTO> charactersDTO = Utils.findAllByNameContains(name);
        when(characterRepository.findAllByNameContains(name)).thenReturn(charactersDTO);
        Assertions.assertSame(findService.find(name), charactersDTO);
    }
}
