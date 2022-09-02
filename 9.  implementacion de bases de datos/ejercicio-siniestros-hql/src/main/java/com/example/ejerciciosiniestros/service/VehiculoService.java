package com.example.ejerciciosiniestros.service;

import com.example.ejerciciosiniestros.dto.VehiculoPatenteDTO;
import com.example.ejerciciosiniestros.model.Vehiculo;
import com.example.ejerciciosiniestros.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

    IVehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo findVehiculoById(long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }

    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void deleteVehiculo(long id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo updateVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<Vehiculo> findAllVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public List<VehiculoPatenteDTO> getVehiculoPatentes() {
        return vehiculoRepository.getVehiculoPatentes().stream().map(VehiculoPatenteDTO::new).collect(Collectors.toList());
    }
}
