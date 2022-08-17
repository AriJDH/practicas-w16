package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.FindService;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository mockCharacterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findTest() {
        var res = mockCharacterRepository.findAllByNameContains("Luke");
        var res2 =  findService.find("Darth");

        verify(mockCharacterRepository).findAllByNameContains("Luke");

        assertNotNull(res2);
        assertNotNull(res);
        assertEquals(res,res2);
    }

    @Test
    void notFoundTest() {
        var res = mockCharacterRepository.findAllByNameContains("asdasdad");
        var res2 =  findService.find("asdasdad");

        assertEquals(0,res.size());
        assertEquals(0,res2.size());
    }
}
