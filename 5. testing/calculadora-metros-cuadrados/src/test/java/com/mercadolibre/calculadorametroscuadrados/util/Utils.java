package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Arrays;

public class Utils {

    public static HouseDTO buildHouse(){
        return new HouseDTO(
                "Mi casa",
                "En mi casa",
                Arrays.asList(
                        new RoomDTO("Dormitorio", 5, 5),
                        new RoomDTO("Cocina", 3, 3),
                        new RoomDTO("baño", 2, 3)
                )
        );
    }

    public static HouseResponseDTO buildResponseHouse(HouseDTO house){
        return new HouseResponseDTO(
                40,
                40*800,
                new RoomDTO("Dormitorio", 5, 5)
        );
    }

    public static Integer getPrice(Integer sqrFeet){
        return sqrFeet * 800;
    }

    public static RoomDTO getBiggestRoom(){
        return new RoomDTO("Dormitorio", 5, 5);
    }
}
