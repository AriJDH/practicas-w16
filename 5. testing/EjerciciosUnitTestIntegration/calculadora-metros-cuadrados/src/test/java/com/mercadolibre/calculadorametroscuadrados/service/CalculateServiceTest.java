package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateServiceTest {

  CalculateService calculateService;


  @Test
  void calculatePriceTest() {
    calculateService = new CalculateService();
    RoomDTO room = new RoomDTO("Habitacion1", 100, 20);
    HouseDTO houseDTO = new HouseDTO("Casa1", "Avenida siempre viva", List.of(room));
    HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
    assertEquals(1600000, houseResponseDTO.getPrice());
  }

  @Test
  void calculateBiggestRoom() {
    calculateService = new CalculateService();
    RoomDTO room1 = new RoomDTO("Habitacion1", 100, 20);
    RoomDTO room2 = new RoomDTO("Habitacion1", 100, 10);
    HouseDTO houseDTO = new HouseDTO("Casa1", "Avenida siempre viva", List.of(room1, room2));
    HouseResponseDTO compareHouseDTO = calculateService.calculate(houseDTO);
    assertEquals(room1, compareHouseDTO.getBiggest());
  }

  @Test
  void calculateSquareFeet() {
    calculateService = new CalculateService();
    RoomDTO room = new RoomDTO("Habitacion1", 100, 20);
    HouseDTO houseDTO = new HouseDTO("Casa1", "Avenida siempre viva", List.of(room));
    HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
    assertEquals(2000, houseResponseDTO.getSquareFeet());
  }

  @Test
  void calculateNoRooms() {
    calculateService = new CalculateService();
    HouseDTO houseDTO = new HouseDTO("Casa1", "Avenida siempre viva", List.of());
    HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
    HouseResponseDTO compreHouseDTO = new HouseResponseDTO(0, 0, null);
    assertEquals(compreHouseDTO, houseResponseDTO);
  }

  @Test
  void calculateAllRooms() {
    calculateService = new CalculateService();
    RoomDTO room1 = new RoomDTO("Habitacion1", 100, 20);
    RoomDTO room2 = new RoomDTO("Habitacion2", 100, 10);
    RoomDTO room4 = new RoomDTO("Habitacion3", 100, 5);

    HouseDTO houseDTO = new HouseDTO("Casa1", "Avenida siempre viva", List.of(room1, room2, room4));
    HouseResponseDTO houseResponseDTO = calculateService.calculate(houseDTO);
    HouseResponseDTO expecteHouseDTO = new HouseResponseDTO(3500, 2800000, room1);
    assertEquals(expecteHouseDTO, houseResponseDTO);
  }

}