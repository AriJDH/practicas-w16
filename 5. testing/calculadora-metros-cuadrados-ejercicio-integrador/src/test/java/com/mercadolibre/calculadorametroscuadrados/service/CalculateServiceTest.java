package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    void initialize() {
        calculateService = new CalculateService();
    }

    @Test
    void calculatePriceOfHouseWithoutRooms() {
        HouseDTO house = new HouseDTO("Casa", "Calle falsa 123", List.of());

        HouseResponseDTO response = calculateService.calculate(house);

        assertThat(response.getPrice()).isEqualTo(0);
    }

    @Test
    void calculatePriceOfHouseWithTwoRooms() {
        List<RoomDTO> rooms =
                List.of(
                        new RoomDTO("Dormitorio", 2, 4),
                        new RoomDTO("Living", 1, 3)
                );
        HouseDTO house = new HouseDTO("Casa", "Calle falsa 123", rooms);

        HouseResponseDTO response = calculateService.calculate(house);

        var expectedPrice = (2*4 + 1*3) * 800;
        assertThat(response.getPrice()).isEqualTo(expectedPrice);
    }

    @Test
    void responseHasSettedTheBiggestRoom() {
        RoomDTO biggestRoom = new RoomDTO("Dormitorio", 2, 4);
        List<RoomDTO> rooms =
                List.of(
                        biggestRoom,
                        new RoomDTO("Living", 1, 3)
                );
        HouseDTO house = new HouseDTO("Casa", "Calle falsa 123", rooms);

        HouseResponseDTO response = calculateService.calculate(house);

        assertThat(response.getBiggest()).isEqualTo(biggestRoom);
    }

}
