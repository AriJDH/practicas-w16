package com.mercadolibre.starwars;


import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {


    @Mock
    FindService service;

    @InjectMocks
    FindController controller;


    @Test
    public void find() {

        String testName = "Luke";
        controller.find(testName);
        verify(service, atLeastOnce()).find(testName);

    }
}
