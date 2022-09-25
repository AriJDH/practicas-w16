package com.vehiculos.seguro.service;


import com.vehiculos.seguro.dto.VehiculoDTO;
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

    @Override
    public List<VehiculoDTO> findAllOrderByAnioFabricacion() {
        return vehiculoRepository.findAllOrderByAnioFabricacion().stream()
                .map(v -> new VehiculoDTO(v.getId(), v.getPatente(), v.getMarca(),v.getModelo(),v.getAnioFabricacion(),v.getCantRuedas()))//(VehiculoDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoDTO> findAllWith4WheelsMadeThisYear() {
        return vehiculoRepository.findAllWith4WheelsMadeThisYear().stream()
                .map(v -> new VehiculoDTO(v.getId(), v.getPatente(), v.getMarca(),v.getModelo(),v.getAnioFabricacion(),v.getCantRuedas()))
               // .map(VehiculoDTO::new)
                .collect(Collectors.toList());
    }
}
