package com.tomas.concesionaria.mapper;

import com.tomas.concesionaria.dto.VehiculoDTO;
import com.tomas.concesionaria.dto.VehiculoMenosServicioDTO;
import com.tomas.concesionaria.entity.Vehiculo;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class VehiculoMapper {

    public VehiculoMenosServicioDTO mapearVehiculoMenosServicioDTO(Vehiculo vehiculoEntity){

        VehiculoMenosServicioDTO vehiculoDTO = new VehiculoMenosServicioDTO();
        vehiculoDTO.setBrand(vehiculoEntity.getBrand());
        vehiculoDTO.setModel(vehiculoEntity.getModel());
        vehiculoDTO.setManufacturingDate(vehiculoEntity.getManufacturingDate());
        vehiculoDTO.setNumberOfKilometers(vehiculoEntity.getNumberOfKilometers());
        vehiculoDTO.setDoors(vehiculoEntity.getDoors());
        vehiculoDTO.setPrice(vehiculoEntity.getPrice());
        vehiculoDTO.setCurrency(vehiculoEntity.getCurrency());
        vehiculoDTO.setCountOfOwners(vehiculoEntity.getCountOfOwners());


        return vehiculoDTO;
    }

    public Vehiculo mapearVehiculo(VehiculoDTO vehiculoDTO, Long idServicio){

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setBrand(vehiculoDTO.getBrand());
        vehiculo.setModel(vehiculoDTO.getModel());
        vehiculo.setManufacturingDate(vehiculoDTO.getManufacturingDate());
        vehiculo.setNumberOfKilometers(vehiculoDTO.getNumberOfKilometers());
        vehiculo.setDoors(vehiculoDTO.getDoors());
        vehiculo.setPrice(vehiculoDTO.getPrice());
        vehiculo.setCurrency(vehiculoDTO.getCurrency());
        vehiculo.setCountOfOwners(vehiculoDTO.getCountOfOwners());
        vehiculo.setIdServicio(idServicio);

        return vehiculo;

    }

    public VehiculoDTO mapearVehiculoDTO(Vehiculo vehiculoEntity){

        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        vehiculoDTO.setBrand(vehiculoEntity.getBrand());
        vehiculoDTO.setModel(vehiculoEntity.getModel());
        vehiculoDTO.setManufacturingDate(vehiculoEntity.getManufacturingDate());
        vehiculoDTO.setNumberOfKilometers(vehiculoEntity.getNumberOfKilometers());
        vehiculoDTO.setDoors(vehiculoEntity.getDoors());
        vehiculoDTO.setPrice(vehiculoEntity.getPrice());
        vehiculoDTO.setCurrency(vehiculoEntity.getCurrency());
        vehiculoDTO.setCountOfOwners(vehiculoEntity.getCountOfOwners());

        return vehiculoDTO;

    }

}
