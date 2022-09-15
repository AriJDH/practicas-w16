package com.example.cars.service;

import com.example.cars.dto.PatentsAndBrandDTO;
import com.example.cars.dto.PatentsDTO;
import com.example.cars.repository.VehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    private ModelMapper modelMapper;
    public List<PatentsDTO> findAllPatents() {
        return this.vehicleRepository.findAll()
                .stream()
                .map(vehicle -> this.modelMapper.map(vehicle, PatentsDTO.class ))
                .collect(Collectors.toList());
    }
    public List<PatentsAndBrandDTO> findAllByOrderByYearOfProduction() {
        return this.vehicleRepository.findAllByOrderByYearOfProduction()
                .stream()
                .map(vehicle -> this.modelMapper.map(vehicle, PatentsAndBrandDTO.class ))
                .collect(Collectors.toList());
    }
}
