package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository mockCharacterRepository;
    @InjectMocks
    private FindService findService;

    @Test
    public void findTest() {
        CharacterDTO characterDTO = new CharacterDTO("gonzalo", "rojo", "verde", "azul", "1993", "masculino", "argentina", "humano", 170, 75);
        List<CharacterDTO> characterDTOList = Arrays.asList(characterDTO);
        when(this.mockCharacterRepository.findAllByNameContains("gonzalo")).thenReturn(characterDTOList);

        List<CharacterDTO> characterDTOListResult = this.findService.find("gonzalo");

        assertEquals("gonzalo", characterDTOListResult.get(0).getName());
        verify(this.mockCharacterRepository, atLeastOnce()).findAllByNameContains("gonzalo");
    }
}
