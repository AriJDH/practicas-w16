package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService mockFindService;

    @InjectMocks
    FindController findController;

    @Test
    void findTest() {
        var res = findController.find("Luke");

        verify(mockFindService).find("Luke");
        assertNotNull(res);
    }

    @Test
    void notFoundTest() {
        var res = findController.find("asdasdasd");

        assertEquals(0,res.size());
    }
}
