package com.bootcamp.demo.service;

import com.bootcamp.demo.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService implements IVehiculoService{

    private final IVehiculoRepository vehiculoRepo;

    public VehiculoService(IVehiculoRepository vehiculoRepo) {
        this.vehiculoRepo = vehiculoRepo;
    }

    @Override
    public String[] getPatentes() {
        String[] salida = vehiculoRepo.getPatentes();
        return salida;
    }
}
