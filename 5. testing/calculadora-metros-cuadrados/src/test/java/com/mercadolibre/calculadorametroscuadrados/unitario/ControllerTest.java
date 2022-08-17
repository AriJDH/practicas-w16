package com.mercadolibre.calculadorametroscuadrados.unitario;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
    @Mock
    CalculateService service;
    @InjectMocks
    CalculateRestController controller;


    @Test
    void calculateControllerTest(){
        HouseDTO houseDTO= new HouseDTO();
        houseDTO.setName("casaLLave");
        houseDTO.setAddress("calle false 123");
        RoomDTO roomDTO1=new RoomDTO();
        roomDTO1.setName("principal");
        roomDTO1.setLength(20);
        roomDTO1.setWidth(20);

        List<RoomDTO> roomDTOS= Arrays.asList(roomDTO1);
        HouseResponseDTO houseResponseDTO=new HouseResponseDTO();
        houseResponseDTO.setPrice(320000);
        houseResponseDTO.setSquareFeet(400);
        houseResponseDTO.setName("principal");
        houseResponseDTO.setBiggest(roomDTO1);

        when(service.calculate(houseDTO)).thenReturn(houseResponseDTO);

        HouseResponseDTO result=controller.calculate(houseDTO);

        Assertions.assertEquals(320000,result.getPrice());
    }
}
