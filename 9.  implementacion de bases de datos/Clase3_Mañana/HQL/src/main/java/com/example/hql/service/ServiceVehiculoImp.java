package com.example.hql.service;

import com.example.hql.dto.*;
import com.example.hql.model.Vehiculo;
import com.example.hql.model.VehiculoBD;
import com.example.hql.repository.RepositoryVehiculo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServiceVehiculoImp implements ServiceVehiculo{
    final RepositoryVehiculo repositoryVehiculo;
    ModelMapper modelMapper = new ModelMapper();

    public ServiceVehiculoImp(RepositoryVehiculo repositoryVehiculo) {
        this.repositoryVehiculo = repositoryVehiculo;
    }

    @Override
    public String add(VehiculoDTO vehiculoDTO) {
        Vehiculo v = modelMapper.map(vehiculoDTO, Vehiculo.class);
        repositoryVehiculo.save(v);
        return "Vehiculo agregado";
    }

    @Override
    public VehiculoIdDTO getById(int id) {
        return modelMapper.map(repositoryVehiculo.getReferenceById(id), VehiculoIdDTO.class);
    }

    @Override
    public List<VehiculoIdDTO> getAll() {
        List<Vehiculo> vehiculos = repositoryVehiculo.findAll();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, VehiculoIdDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteDTO> findPatenteAll() {
        return repositoryVehiculo.findPatenteAll().stream()
                .map(PatenteDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<StringX2> findPatenteMarcaAll() {
        return repositoryVehiculo.findPatenteMarcaAll().stream()
                .map(patente-> new StringX2(patente.getPatente(), patente.getMarca()))
                .collect(Collectors.toList());
    }

    @Override
    public List<StringX3> findPatenteMarcaModeloBySiniestroPerdida() {
        return repositoryVehiculo.findPatenteMarcaModeloBySiniestroPerdida().stream()
                .map(vehiculo -> new StringX3(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoBDDTO> findPatenteMarcaModeloBySiniestroPerdidaTotal() {
        return repositoryVehiculo.findPatenteMarcaModeloBySiniestroPerdidaTotal().stream()
                .map(vehiculoBD -> new VehiculoBDDTO(vehiculoBD.getPatente(), vehiculoBD.getMarca(), vehiculoBD.getModelo(), vehiculoBD.getPerdida_Total()))
                .collect(Collectors.toList());
    }
}
