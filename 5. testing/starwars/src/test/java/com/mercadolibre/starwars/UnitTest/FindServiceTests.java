package com.mercadolibre.starwars.UnitTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    private final List<CharacterDTO> dataList = new ArrayList<>();

    @BeforeEach
    public void loadDataTest() {
        System.out.println("init");
        dataList.addAll(characterRepository.loadDataBase());
    }

    @Test
    public void findTest() {
        List<CharacterDTO> luck = dataList.stream().filter(x -> x.getName().contains("Luke")).collect(Collectors.toList());
        when(characterRepository.findAllByNameContains("Luke")).thenReturn(luck);

        List<CharacterDTO> getByName = findService.find("Luke");

        verify(characterRepository, atLeastOnce()).findAllByNameContains("Luke");
        assertEquals(luck, getByName);
    }
}
