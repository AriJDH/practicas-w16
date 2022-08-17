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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;
    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    void calculate() {
        RoomDTO room1 = new RoomDTO("habitacion1",100,20);
        HouseDTO houseDTO= new HouseDTO("1","2",List.of(room1));
        HouseResponseDTO houseResponseDTOExpected = new HouseResponseDTO(2000,1600000,room1);
        Mockito.when(calculateService.calculate(Mockito.any())).thenReturn(houseResponseDTOExpected);
        HouseResponseDTO houseResponseDTO = calculateRestController.calculate(houseDTO);
        assertEquals(houseResponseDTOExpected,houseResponseDTO);
    }
}