package com.mercadolibre.calculadorametroscuadrados.service;

import java.util.List;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraMetrosCuadradosService {

   private CalculateService calculateService;
   private HouseDTO house;
   private RoomDTO living;
   private RoomDTO cocina;

   @BeforeEach
   void setUp() {
      calculateService = new CalculateService();

      house = new HouseDTO();

      house.setName("Casa");
      house.setAddress("150");
      house.setRooms(List.of());

      living = new RoomDTO();
      cocina = new RoomDTO();

      living.setName("Living");
      living.setWidth(2);
      living.setLength(2);

      cocina.setName("Cocina");
      cocina.setWidth(4);
      cocina.setLength(4);

   }

   @Test
   void calculatePriceOfHouseOfZeroRooms() {
      HouseResponseDTO response = calculateService.calculate(house);

      Assertions.assertThat(response.getPrice().equals(0));

   }

   @Test
   void shouldRetriveBiggestRoom() {

      List<RoomDTO> rooms = List.of(living, cocina);

      house.setRooms(rooms);

      HouseResponseDTO response = calculateService.calculate(house);

      Assertions.assertThat(response.getBiggest().equals(cocina));
   }

   @Test
   void shouldRetriveExpectedPrice() {

      List<RoomDTO> rooms = List.of(living, cocina);

      house.setRooms(rooms);

      HouseResponseDTO response = calculateService.calculate(house);

      Assertions.assertThat(response.getPrice().equals(((2 * 2) + (4 * 4)) * 800));

   }

   @Test
   void shouldCalculateSquareFeetCorrectly() {

      List<RoomDTO> rooms = List.of(living, cocina);

      house.setRooms(rooms);

      HouseResponseDTO response = calculateService.calculate(house);

      Assertions.assertThat(living.getSquareFeet().equals(4));
      Assertions.assertThat(cocina.getSquareFeet().equals(16));
      Assertions.assertThat(response.getSquareFeet().equals(20));

   }

}
