package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

  @Mock
  CalculateService calculateService;

  @InjectMocks
  CalculateRestController calculateRestController;


  @Test
  void calculate() {
    RoomDTO room1 = new RoomDTO("Habitacion1", 100, 20);
    HouseResponseDTO expectHouse = new HouseResponseDTO(2000, 1600000, room1);

    when(calculateService.calculate(Mockito.any())).thenReturn(expectHouse);
    HouseResponseDTO responseHouse = calculateRestController.calculate(null);

    assertEquals(expectHouse, responseHouse);

  }
}