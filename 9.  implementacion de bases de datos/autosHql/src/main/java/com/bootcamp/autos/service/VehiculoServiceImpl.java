package com.bootcamp.autos.service;

import com.bootcamp.autos.dto.VehiculoPatentesDto;
import com.bootcamp.autos.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoPatentesDto> getPatentesVehiculos() {
        return vehiculoRepository.getPatentesVehiculos()
                .stream()
                .map(VehiculoPatentesDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<HashMap<String, String>> getPatenteMarcaVehiculos() {
        return vehiculoRepository.getPatenteMarcaVehiculos();
    }

    @Override
    public List<VehiculoPatentesDto> getPatentesByFechaByRuedaVehiculos() {
        return vehiculoRepository.getPatentesByFechaByRuedaVehiculos()
                .stream()
                .map(VehiculoPatentesDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<HashMap<String, String>> getVehiculosSiniestro() {
        return vehiculoRepository.getVehiculosSiniestro();
    }

    @Override
    public List<HashMap<String, Object>> getVehiculosSiniestroTotalPerdida() {
        return vehiculoRepository.getVehiculosSiniestroTotalPerdida();
    }
}
