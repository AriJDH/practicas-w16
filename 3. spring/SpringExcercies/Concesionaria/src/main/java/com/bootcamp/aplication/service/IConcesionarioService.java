package com.bootcamp.aplication.service;

import com.bootcamp.aplication.dto.CarDTO;
import com.bootcamp.aplication.dto.CarResponseDTO;

import java.util.List;

public interface IConcesionarioService {

    CarDTO saveData(CarDTO dto);

    List<CarResponseDTO> getAllCars();

    List<CarResponseDTO> findSinceDate(String order);

    List<CarResponseDTO> findSincePrice(String order);

    CarDTO findById(int id);
}
