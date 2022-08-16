package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    void findCharactersShouldReturnAList() {
        CharacterDTO aCharacter = new CharacterDTO();
        CharacterDTO anotherCharacter = new CharacterDTO();
        aCharacter.setName("Luke Star");
        aCharacter.setName("Luke Wars");

        Mockito
                .when(findService.find("Luke"))
                .thenReturn(List.of(
                        aCharacter,
                        anotherCharacter
                ));

        List<CharacterDTO> characters =
                findController.find("Luke");

        Assertions.assertThat(characters.size()).isEqualTo(2);
        Assertions.assertThat(characters.contains(aCharacter)).isTrue();
        Assertions.assertThat(characters.contains(anotherCharacter)).isTrue();
    }

}
