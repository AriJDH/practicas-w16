package com.mercadolibre.calculadorametroscuadrados.unitario;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

public class ServiceTest {

    CalculateService service;

    @BeforeEach
    void setUp(){
    service=new CalculateService();
    }

    @Test
    public void calculateWithDataTest(){

        HouseDTO houseDTO= new HouseDTO();
        houseDTO.setName("casaLLave");
        houseDTO.setAddress("calle false 123");
        RoomDTO roomDTO1=new RoomDTO();
        roomDTO1.setName("principal");
        roomDTO1.setLength(20);
        roomDTO1.setWidth(20);
        RoomDTO roomDTO2=new RoomDTO();
        roomDTO1.setName("segunda");
        roomDTO1.setLength(30);
        roomDTO1.setWidth(30);
        List<RoomDTO> roomDTOS= Arrays.asList(roomDTO1,roomDTO2);
        houseDTO.setRooms(roomDTOS);

        HouseResponseDTO result=service.calculate(houseDTO);

        Assertions.assertEquals(720000,result.getPrice());
    }

}
