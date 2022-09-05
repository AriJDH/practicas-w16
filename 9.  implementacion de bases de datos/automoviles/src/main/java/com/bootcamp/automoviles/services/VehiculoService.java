package com.bootcamp.automoviles.services;

import com.bootcamp.automoviles.dto.*;
import com.bootcamp.automoviles.entities.Vehiculos;
import com.bootcamp.automoviles.repositories.IVehiculoRepository;
import com.bootcamp.automoviles.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{
    private final IVehiculoRepository vehiculoRepository;

    @Autowired
    public  VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public VehiculoDTO create(VehiculoDTO vehiculoDTO) {
        Vehiculos newVehiculo = vehiculoRepository.save(ModelMapper.parseFromVehiculoDTO(vehiculoDTO));
        return ModelMapper.parseFromVehiculoWhitID(newVehiculo);
    }

    @Override
    public List<VehiculoDTO> find() {
        return vehiculoRepository.findAll().stream()
                .map(ModelMapper::parseFromVehiculoWhitSiniestro)
                .collect(Collectors.toList());
    }

    public List<VehiculoPatenteDTO> findPatentes() {
        List<Vehiculos> vehiculos = vehiculoRepository.findPatentes();
        return vehiculos.stream().map(ModelMapper::parseToVehiculoPatente).collect(Collectors.toList());
    }

    @Override
    public List<VehiculoMarcaDTO> findPatenteYMarca() {
        return vehiculoRepository.findPatenteAndMarcaOrderByAnioFabricacionDESC()
                .stream().map(ModelMapper::parseToVehiculoMarca)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteDTO> findMoreThan4Wheels() {
        return vehiculoRepository.findMoreThan4Wheel()
                .stream().map(ModelMapper::parseToVehiculoPatente)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoPatenteDTO> findLostMoreThan10000() {
        return vehiculoRepository.findLostMoreThan10000()
                .stream()
                .map(ModelMapper::parseToVehiculoPatente)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoSiniestroDTO> findTotales() {
        List<VehiculoSiniestro> lista = vehiculoRepository.findLostMoreThan10000Vehicule();
        return lista.stream().map(vehiculoSiniestro -> {
            System.out.println("vehiculoSiniestro = " + vehiculoSiniestro.getVehiculos().getPatente());
            VehiculoMarcaDTO vehiculo = new VehiculoMarcaDTO(vehiculoSiniestro.getVehiculos().getPatente(),vehiculoSiniestro.getVehiculos().getMarca());
            VehiculoSiniestroDTO vehiculoSiniestroDTO = new VehiculoSiniestroDTO(vehiculo, vehiculoSiniestro.getPerdida());
            return vehiculoSiniestroDTO;
        }).collect(Collectors.toList());
    }
}
