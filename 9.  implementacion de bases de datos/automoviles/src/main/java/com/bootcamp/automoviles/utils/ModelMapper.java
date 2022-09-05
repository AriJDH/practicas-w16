package com.bootcamp.automoviles.utils;

import com.bootcamp.automoviles.dto.*;
import com.bootcamp.automoviles.entities.Siniestros;
import com.bootcamp.automoviles.entities.Vehiculos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ModelMapper {

    public static VehiculoDTO parseFromVehiculo(Vehiculos vehiculo){
        return VehiculoDTO.builder()
                .id(vehiculo.getId())
                .marca(vehiculo.getMarca())
                .cantidadRuedas(vehiculo.getCantidadRuedas())
                .patente(vehiculo.getPatente())
                .anioFabricacion(vehiculo.getAnioFabricacion())
                .build();
    }

    public static VehiculoDTO parseFromVehiculoWhitID(Vehiculos vehiculo){
        return VehiculoDTO.builder()
                .id(vehiculo.getId())
                .marca(vehiculo.getMarca())
                .cantidadRuedas(vehiculo.getCantidadRuedas())
                .patente(vehiculo.getPatente())
                .anioFabricacion(vehiculo.getAnioFabricacion())
                .build();
    }

    public static VehiculoDTO parseFromVehiculoWhitSiniestro(Vehiculos vehiculo){
        return VehiculoDTO.builder()
                .id(vehiculo.getId())
                .marca(vehiculo.getMarca())
                .cantidadRuedas(vehiculo.getCantidadRuedas())
                .patente(vehiculo.getPatente())
                .anioFabricacion(vehiculo.getAnioFabricacion())
                .siniestros(parseSiniestros_DTOFromSiniestros(vehiculo.getSiniestros()))
                .build();
    }

    public static Siniestro_DTO parseSiniestro_DTOFromSiniestro(Siniestros siniestros) {
        return Siniestro_DTO.builder()
                .id(siniestros.getId())
                .fechaSiniestro(siniestros.getFechaSiniestro())
                .perdidaEconomica(siniestros.getPerdidaEconomica())
                .vehiculo_id(siniestros.getVehiculos().getId())
                .build();
    }

    public static List<Siniestro_DTO> parseSiniestros_DTOFromSiniestros(Set<Siniestros> siniestros) {
        return siniestros.stream()
                .map(ModelMapper::parseSiniestro_DTOFromSiniestro)
                .collect(Collectors.toList());
    }

    public static Vehiculos parseFromVehiculoDTO(VehiculoDTO vehiculoDTO){
        return Vehiculos.builder()
                .marca(vehiculoDTO.getMarca())
                .cantidadRuedas(vehiculoDTO.getCantidadRuedas())
                .patente(vehiculoDTO.getPatente())
                .anioFabricacion(vehiculoDTO.getAnioFabricacion())
                .build();
    }

    public static Siniestro_DTO parseFromSiniestro(Siniestros siniestros) {
        return Siniestro_DTO.builder()
                .id(siniestros.getId())
                .perdidaEconomica(siniestros.getPerdidaEconomica())
                .fechaSiniestro(siniestros.getFechaSiniestro())
                .vehiculo_id(siniestros.getVehiculos().getId())
                .build();
    }

    public static SiniestroDTO parseFromSiniestros(Siniestros siniestros) {
        return SiniestroDTO.builder()
                .id(siniestros.getId())
                .perdidaEconomica(siniestros.getPerdidaEconomica())
                .fechaSiniestro(siniestros.getFechaSiniestro())
                .vehiculos(parseFromVehiculo(siniestros.getVehiculos()))
                .build();
    }

    public static Siniestros parseFromSieniestroDTO(Siniestro_DTO siniestroDTO) {
        return Siniestros.builder()
                .id(siniestroDTO.getId())
                .perdidaEconomica(siniestroDTO.getPerdidaEconomica())
                .fechaSiniestro(siniestroDTO.getFechaSiniestro())
                .vehiculos(new Vehiculos(siniestroDTO.getVehiculo_id()))
                .build();
    }

    public static VehiculoPatenteDTO parseToVehiculoPatente(Vehiculos vehiculos){
        return VehiculoPatenteDTO.builder()
                .id(vehiculos.getId())
                .patente(vehiculos.getPatente())
                .build();
    }

    public static VehiculoMarcaDTO parseToVehiculoMarca(Vehiculos vehiculos) {
        return VehiculoMarcaDTO.builder()
                .patente(vehiculos.getPatente())
                .marca(vehiculos.getMarca())
                .build();
    }

}
