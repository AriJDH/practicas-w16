package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void find() {
        List<CharacterDTO> list = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        list.add(characterDTO);
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(list);

        List<CharacterDTO> listExpected = findService.find("Luke");
        verify(characterRepository,atLeastOnce()).findAllByNameContains("Luke");
        assertEquals(list,listExpected);
    }
}