package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest
{

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @Test
    void whenFindCharactersByNameShouldReturnCharactersThatMatchWithGivenName() {
        CharacterDTO aCharacter = new CharacterDTO();
        CharacterDTO anotherCharacter = new CharacterDTO();
        aCharacter.setName("Luke Guerras");
        aCharacter.setName("Luke De las galaxias");

        Mockito
                .when(characterRepository.findAllByNameContains("Luke"))
                .thenReturn(List.of(
                        aCharacter,
                        anotherCharacter
                ));

        List<CharacterDTO> characters =
                findService.find("Luke");

        Assertions.assertThat(characters.size()).isEqualTo(2);
        Assertions.assertThat(characters.contains(aCharacter)).isTrue();
        Assertions.assertThat(characters.contains(anotherCharacter)).isTrue();
    }

}
