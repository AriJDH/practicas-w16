package com.bootcamp.dealership.util;

import com.bootcamp.dealership.dto.request.VehicleReqDTO;
import com.bootcamp.dealership.dto.response.VehicleResDTO;
import com.bootcamp.dealership.entity.Vehicle;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static VehicleResDTO mapVehicleToVehicleDTO(Vehicle vehicle){
        VehicleResDTO vehicleDTO = new VehicleResDTO();
        vehicleDTO.setBrand(vehicle.getBrand());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setDoors(vehicle.getDoors());
        vehicleDTO.setModel(vehicle.getModel());
        vehicleDTO.setCountOfOwners(vehicle.getCountOfOwners());
        vehicleDTO.setPrice(vehicle.getPrice());
        vehicleDTO.setCurrency(vehicle.getCurrency());
        vehicleDTO.setNumberOfKilometers(vehicle.getNumberOfKilometers());
        vehicleDTO.setManufacturingDate(vehicle.getManufacturingDate());
        vehicleDTO.setId(vehicle.getId());
        return vehicleDTO;
    }

    public static Vehicle VehicleReqDTOToVehicle(VehicleReqDTO vehicleReqDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand(vehicleReqDTO.getBrand());
        vehicle.setCurrency(vehicleReqDTO.getCurrency());
        vehicle.setDoors(vehicleReqDTO.getDoors());
        vehicle.setModel(vehicleReqDTO.getModel());
        vehicle.setCountOfOwners(vehicleReqDTO.getCountOfOwners());
        vehicle.setPrice(vehicleReqDTO.getPrice());
        vehicle.setCurrency(vehicleReqDTO.getCurrency());
        vehicle.setNumberOfKilometers(vehicleReqDTO.getNumberOfKilometers());
        vehicle.setServices(vehicleReqDTO.getServices());
        vehicle.setManufacturingDate(vehicleReqDTO.getManufacturingDate());
        return vehicle;
    }

    public static LocalDate parseDate(String date){
        List<Integer> arrayDate = Arrays.stream(date.split("-"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return LocalDate.of(arrayDate.get(0), arrayDate.get(1), arrayDate.get(2));
    }
}
