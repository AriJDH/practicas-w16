package com.mercadolibre.starwars.UnitTest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findTest() {
        List<CharacterDTO> data = TestUtilsGenerator.loadDataBase().stream().filter(x -> x.getName().contains("Luke")).collect(Collectors.toList());
        when(findService.find("Luke")).thenReturn(data);

        List<CharacterDTO> findCharacters = findController.find("Luke");

        verify(findService, atLeastOnce()).find("Luke");
        assertEquals(data, findCharacters);
    }
}
