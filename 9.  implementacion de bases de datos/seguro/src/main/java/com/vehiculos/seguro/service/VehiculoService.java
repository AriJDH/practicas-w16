package com.vehiculos.seguro.service;

import com.vehiculos.seguro.dto.VehiculoPatenteDTO;
import com.vehiculos.seguro.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoPatenteDTO> listAllByPatente() {
        return vehiculoRepository.findAllByPatente().stream()
                .map( v -> new VehiculoPatenteDTO(v.getPatente()))
                .collect(Collectors.toList());
    }
}
