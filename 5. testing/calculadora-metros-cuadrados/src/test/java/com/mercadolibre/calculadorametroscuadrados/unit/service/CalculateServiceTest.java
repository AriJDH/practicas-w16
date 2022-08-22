package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.ModelCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CalculateServiceTest {
    @Autowired
    CalculateService service;
    HouseDTO houseDTO;

    @BeforeEach
    public void setUp(){
        houseDTO = ModelCreator.createHouse("Casa1");
    }

    @Test
    public void calculateTest(){
        Integer houseSquareFeet = houseDTO.getRooms().stream()
                .reduce(0, (acc, roomDTO) -> acc + roomDTO.getSquareFeet(), Integer::sum);
        Assertions.assertEquals(houseSquareFeet, service.calculate(houseDTO).getSquareFeet());
    }
}
