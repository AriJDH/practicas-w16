package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    private FindService mockFindService;
    @InjectMocks
    private FindController findController;

    @Test
    public void findTest() {
        CharacterDTO characterDTO = new CharacterDTO("gonzalo", "rojo", "verde", "azul", "1993", "masculino", "argentina", "humano", 170, 75);
        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO);
        when(this.mockFindService.find("gonzalo")).thenReturn(characterDTOList);

        List<CharacterDTO> characterDTOListResult = this.findController.find("gonzalo");

        assertEquals("gonzalo", characterDTOListResult.get(0).getName());
        verify(this.mockFindService, atLeastOnce()).find("gonzalo");
    }
}
