package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.ResponseApiDTO;
import com.bootcamp.seguros.dto.ResponsePatenteDTO;
import com.bootcamp.seguros.dto.ResponsePatenteMarcaDTO;
import com.bootcamp.seguros.dto.VehiculoDTO;
import com.bootcamp.seguros.model.Vehiculo;
import com.bootcamp.seguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
    @Autowired
    IVehiculoRepository vehiculoRepository;

    private final ModelMapper mapper;

    public VehiculoServiceImpl() {
        this.mapper = new ModelMapper();
    }

    @Override
    public List<ResponsePatenteDTO> findAllPatentes() {
        return vehiculoRepository.findAllPatentes()
                .stream()
                .map(ResponsePatenteDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponsePatenteMarcaDTO> findAllOrderByDate() {
        return vehiculoRepository.findAllOrderByDate()
                .stream()
                .map(v-> new ResponsePatenteMarcaDTO(v.getPatente(),v.getMarca()))
                .collect(Collectors.toList());
    }

    public ResponseApiDTO createVehiculo(VehiculoDTO vehiculoDTO){
        Vehiculo vehiculo = mapper.map(vehiculoDTO,Vehiculo.class);
        vehiculo.getSiniestros().forEach((i)->i.setVehiculo(vehiculo));
        vehiculoRepository.save(vehiculo);
        int id= vehiculoRepository.findAll().size();
        return new ResponseApiDTO("Creacion Vehiculo","Vehiculo Creado con id "+id);
    }
}
