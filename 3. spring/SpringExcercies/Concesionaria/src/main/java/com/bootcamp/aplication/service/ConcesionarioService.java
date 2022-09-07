package com.bootcamp.aplication.service;

import com.bootcamp.aplication.dto.CarDTO;
import com.bootcamp.aplication.dto.CarResponseDTO;
import com.bootcamp.aplication.repository.ConcesionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcesionarioService implements IConcesionarioService {

    @Autowired
    ConcesionarioRepository repository;

    @Override
    public CarDTO saveData(CarDTO dto) {

        return repository.saveDAta(dto);
    }

    @Override
    public List<CarResponseDTO> getAllCars() {
        return repository.getAllCars();
    }

    @Override
    public List<CarResponseDTO> findSinceDate(String order) {
        System.out.println(order);

        List<CarResponseDTO> responseList = new ArrayList<>();

        if (order.equals(null) || order.equalsIgnoreCase("desc"))
            responseList = getAllCars().stream().sorted(Comparator.comparing(CarResponseDTO::getManufacturingDate).reversed())
                    .collect(Collectors.toList());
        else if (order.equalsIgnoreCase("asc"))
            responseList = getAllCars().stream().sorted(Comparator.comparing(CarResponseDTO::getManufacturingDate))
                    .collect(Collectors.toList());
        else
            responseList.add(new CarResponseDTO());

        return responseList;
    }

    @Override
    public List<CarResponseDTO> findSincePrice(String order) {

        List<CarResponseDTO> responseList = new ArrayList<>();

        if (order.equals(null) || order.equalsIgnoreCase("desc"))
            responseList = getAllCars().stream().sorted(Comparator.comparing(CarResponseDTO::getPrice).reversed())
                    .collect(Collectors.toList());
        else if (order.equalsIgnoreCase("asc"))
            responseList = getAllCars().stream().sorted(Comparator.comparing(CarResponseDTO::getPrice))
                    .collect(Collectors.toList());
        else
            responseList.add(new CarResponseDTO());

        return responseList;
    }

    @Override
    public CarDTO findById(int id) {
        return repository.getById(id);
    }
}
