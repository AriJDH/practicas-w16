package com.mercadolibre.calculadorametroscuadrados;


import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateServiceUnitTests {

    CalculateService service;

    public CalculateServiceUnitTests(){
        this.service = new CalculateService();
    }

    @Test
    public void TestCalculateGlobal(){

        //Arrange
        HouseDTO house = Utils.buildHouse();
        HouseResponseDTO response = Utils.buildResponseHouse(house);

        //Act
        //Assert
        Assertions.assertEquals(response, service.calculate(house));
    }

    @Test
    public void TestCalculatePrice(){

        //Arrange
        HouseDTO house = Utils.buildHouse();

        //Act
        //Assert
        Assertions.assertEquals(Utils.getPrice(40), service.calculate(house).getPrice());
    }

    @Test
    public void TestCalculateSqrFeet(){

        //Arrange
        HouseDTO house = Utils.buildHouse();

        //Act
        //Assert
        Assertions.assertEquals(40, service.calculate(house).getSquareFeet());
    }

    @Test
    public void TestBiggestRoom(){

        //Arrange
        HouseDTO house = Utils.buildHouse();
        RoomDTO expected = Utils.getBiggestRoom();

        //Act
        //Assert
        Assertions.assertEquals(expected, service.calculate(house).getBiggest());
    }
}
