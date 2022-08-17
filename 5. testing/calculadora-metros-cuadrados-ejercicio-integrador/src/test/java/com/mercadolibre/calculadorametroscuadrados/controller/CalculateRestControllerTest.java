package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController controller;

    @Test
    void calculateDataForHouseWithoutRooms() {
        HouseDTO house = new HouseDTO("Casa", "Fake 123", List.of());
        var responseDTO =
                new HouseResponseDTO(house);
        responseDTO.setBiggest(null);
        responseDTO.setSquareFeet(0);
        responseDTO.setPrice(0);
        responseDTO.setRooms(List.of());

        Mockito
                .when(calculateService.calculate(house))
                .thenReturn(responseDTO);

        var response = controller.calculate(house);

        Assertions.assertEquals(response.getSquareFeet(), 0);
        Assertions.assertEquals(response.getPrice(), 0);
        Assertions.assertEquals(response.getBiggest(), null);
        Assertions.assertEquals(response.getAddress(), "Fake 123");
        Assertions.assertEquals(response.getName(), "Casa");
        Assertions.assertTrue(response.getRooms().isEmpty());
    }

}
