package com.bootcamp.aplication.repository;

import com.bootcamp.aplication.dto.CarDTO;
import com.bootcamp.aplication.dto.CarResponseDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ConcesionarioRepository {

    Map<Integer, CarDTO> carMap = new HashMap<>();

    public CarDTO saveDAta(CarDTO dto) {

        carMap.put(carMap.size(), dto);

        return carMap.get(carMap.size() - 1);
    }

    public List<CarResponseDTO> getAllCars() {
        List<CarResponseDTO> dtoList = new ArrayList<>();

        for (Map.Entry entry : carMap.entrySet()) {
            CarDTO carDTO = (CarDTO) entry.getValue();
            CarResponseDTO newCar = new CarResponseDTO();

            newCar.setBrand(carDTO.getBrand());
            newCar.setModel(carDTO.getModel());
            newCar.setManufacturingDate(carDTO.getManufacturingDate());
            newCar.setNomberOfKilometers(carDTO.getNomberOfKilometers());
            newCar.setDoors(carDTO.getDoors());
            newCar.setPrice(carDTO.getPrice());
            newCar.setCurrency(carDTO.getCurrency());
            newCar.setCountOfOwners(carDTO.getCountOfOwners());

            dtoList.add(newCar);
        }

        return dtoList;
    }

    public CarDTO getById(int id) {
        CarDTO carDTO = new CarDTO();

        for (Map.Entry entry : carMap.entrySet()) {
            if (entry.getKey().equals(id))
                carDTO = (CarDTO) entry.getValue();
        }

        return carDTO;
    }
}
