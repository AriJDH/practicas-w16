package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CharacterRepositoryImplTest {
    CharacterRepositoryImpl characterRepository;

    @Test
    void findAllByNameContains() {
        characterRepository = new CharacterRepositoryImpl();
        List<CharacterDTO> list = new ArrayList<>();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        list.add(characterDTO);
        List<CharacterDTO> listExpected = characterRepository.findAllByNameContains("Luke");
        assertEquals(list.get(0).getName(),listExpected.get(0).getName());
    }
}