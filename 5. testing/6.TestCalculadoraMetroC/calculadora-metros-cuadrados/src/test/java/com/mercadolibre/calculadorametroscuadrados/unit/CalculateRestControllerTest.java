package com.mercadolibre.calculadorametroscuadrados.unit;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mercadolibre.calculadorametroscuadrados.unit.util.HouseUtil.generateHouseDTO;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;


    @Test
    @DisplayName("Validate response DTO")
    void test1() {
        //Arrange
        HouseDTO house = generateHouseDTO();
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(house);
        houseResponseDTO.setBiggest(house.getRooms().get(1));
        houseResponseDTO.setPrice(10000000);
        houseResponseDTO.setSquareFeet(12500);
        when(calculateService.calculate(house)).thenReturn(houseResponseDTO);

        //Act
        HouseResponseDTO resultHouseDTO = calculateRestController.calculate(house);
        //Assert
        Assertions.assertEquals(houseResponseDTO , resultHouseDTO);
    }
}
