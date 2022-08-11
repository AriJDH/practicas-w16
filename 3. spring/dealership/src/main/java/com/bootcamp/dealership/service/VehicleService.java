package com.bootcamp.dealership.service;

import com.bootcamp.dealership.dto.request.VehicleReqDTO;
import com.bootcamp.dealership.dto.response.VehicleResDTO;
import com.bootcamp.dealership.entity.Vehicle;
import com.bootcamp.dealership.repository.IRepository;
import com.bootcamp.dealership.repository.VehicleRepository;
import com.bootcamp.dealership.util.Util;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IService<VehicleResDTO, VehicleReqDTO> {
    private final IRepository<Vehicle> vehicleIRepository;

    public VehicleService(VehicleRepository vehicleIRepository) {
        this.vehicleIRepository = vehicleIRepository;
    }

    @Override
    public List<VehicleResDTO> findAll(Map<String, String> filter) {
        return vehicleIRepository.findAll(filter).stream()
                .map(Util::mapVehicleToVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResDTO> findByPrices(Map<String, String> filter) {
        return vehicleIRepository.findByPrices(filter).stream()
                .map(Util::mapVehicleToVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleResDTO> findByDates(Map<String, String> filter) {
        return vehicleIRepository.findByDates(filter).stream()
                .map(Util::mapVehicleToVehicleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleResDTO findById(Long id) {
        return Util.mapVehicleToVehicleDTO(this.vehicleIRepository.findById(id));
    }

    @Override
    public VehicleResDTO save(VehicleReqDTO vehicleReqDTO) {
        Vehicle vehicle = Util.VehicleReqDTOToVehicle(vehicleReqDTO);
        return Util.mapVehicleToVehicleDTO(this.vehicleIRepository.save(vehicle));
    }
}
