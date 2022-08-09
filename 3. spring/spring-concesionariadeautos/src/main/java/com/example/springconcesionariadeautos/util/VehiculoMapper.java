package com.example.springconcesionariadeautos.util;

import com.example.springconcesionariadeautos.dto.VehiculoDTO;
import com.example.springconcesionariadeautos.dto.VehiculoSinServiceDTO;
import com.example.springconcesionariadeautos.entity.Vehiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VehiculoMapper {
    public static Vehiculo getVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = new Vehiculo(0,
                vehiculoDTO.getBrand(),
                vehiculoDTO.getModel(),
                vehiculoDTO.getManufacturingDate(),
                vehiculoDTO.getNumberOfKilometers(),
                vehiculoDTO.getDoors(),
                vehiculoDTO.getPrice(),
                vehiculoDTO.getCurrency(),
                vehiculoDTO.getServices(),
                vehiculoDTO.getCountOfOwners());

        return vehiculo;
    }

    public static VehiculoDTO getVehiculoDTO(Vehiculo vehiculo){
        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setBrand(vehiculo.getBrand());
        vehiculoDTO.setModel(vehiculo.getModel());
        vehiculoDTO.setManufacturingDate(vehiculo.getManufacturingDate());
        vehiculoDTO.setNumberOfKilometers(vehiculo.getNumberOfKilometers());
        vehiculoDTO.setDoors(vehiculo.getDoors());
        vehiculoDTO.setPrice(vehiculo.getPrice());
        vehiculoDTO.setCurrency(vehiculo.getCurrency());
        vehiculoDTO.setServices(vehiculo.getServices());
        vehiculoDTO.setCountOfOwners(vehiculo.getCountOfOwners());

        return vehiculoDTO;
    }

    public static List<VehiculoDTO> getVehiculoDTOList(List<Vehiculo> listaDeVehiculos){
        return listaDeVehiculos.stream().map(vehiculo -> {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.setBrand(vehiculo.getBrand());
            vehiculoDTO.setModel(vehiculo.getModel());
            vehiculoDTO.setManufacturingDate(vehiculo.getManufacturingDate());
            vehiculoDTO.setNumberOfKilometers(vehiculo.getNumberOfKilometers());
            vehiculoDTO.setDoors(vehiculo.getDoors());
            vehiculoDTO.setPrice(vehiculo.getPrice());
            vehiculoDTO.setCurrency(vehiculo.getCurrency());
            vehiculoDTO.setServices(vehiculo.getServices());
            vehiculoDTO.setCountOfOwners(vehiculo.getCountOfOwners());

            return vehiculoDTO;
        }).collect(Collectors.toList());
    }

    public static List<VehiculoSinServiceDTO> getVehiculoSinServiceDTOList(List<Vehiculo> listaDeVehiculos){
        return listaDeVehiculos.stream().map(vehiculo -> {
            VehiculoSinServiceDTO vehiculoSinServiceDTO = new VehiculoSinServiceDTO();
            vehiculoSinServiceDTO.setBrand(vehiculo.getBrand());
            vehiculoSinServiceDTO.setModel(vehiculo.getModel());
            vehiculoSinServiceDTO.setManufacturingDate(vehiculo.getManufacturingDate());
            vehiculoSinServiceDTO.setNumberOfKilometers(vehiculo.getNumberOfKilometers());
            vehiculoSinServiceDTO.setDoors(vehiculo.getDoors());
            vehiculoSinServiceDTO.setPrice(vehiculo.getPrice());
            vehiculoSinServiceDTO.setCurrency(vehiculo.getCurrency());
            vehiculoSinServiceDTO.setCountOfOwners(vehiculo.getCountOfOwners());

            return vehiculoSinServiceDTO;
        }).collect(Collectors.toList());
    }
}
