package com.concesionaria.concensionaria.service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.concesionaria.concensionaria.repository.ConcensionariaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.concesionaria.concensionaria.dto.VehicleDTO;
import com.concesionaria.concensionaria.entity.VehicleEntity;

@Service
public class VehicleService {
    private final ConcensionariaRepository repository;

    public VehicleService(ConcensionariaRepository repository) {
        this.repository = repository;
    }

    public List<VehicleDTO> getAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        List<VehicleDTO> vehicles = repository.getAllVehicles().stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).collect(Collectors.toList());
        
        return vehicles;
    }

    public List<VehicleDTO> getVehiclesByDate(Date since, Date to) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        List<VehicleDTO> vehicles = repository.getVehiclesByDate(since, to).stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).collect(Collectors.toList());
        
        return vehicles;
    }

    public List<VehicleDTO> getVehiclesByPrice(Double since, Double to) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        List<VehicleDTO> vehicles = repository.getVehiclesByPrice(since, to).stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).collect(Collectors.toList());
        
        return vehicles;
    }

    public boolean addVehicle(VehicleEntity vehicle) {
        return repository.addVehicle(vehicle);
    }

    public VehicleDTO getVehicleById(String id) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        return mapper.convertValue(repository.getVehicleById(id), VehicleDTO.class);
    }
}
