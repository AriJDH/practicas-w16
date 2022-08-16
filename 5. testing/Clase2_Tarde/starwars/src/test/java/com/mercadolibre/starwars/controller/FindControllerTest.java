package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
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
class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void find() {
        List<CharacterDTO> list = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        list.add(characterDTO);
        when(findService.find("Luke")).thenReturn(list);
        List<CharacterDTO> listExpected = findController.find("Luke");
        verify(findService,atLeastOnce()).find("Luke");
        assertEquals(list,listExpected);
    }
}