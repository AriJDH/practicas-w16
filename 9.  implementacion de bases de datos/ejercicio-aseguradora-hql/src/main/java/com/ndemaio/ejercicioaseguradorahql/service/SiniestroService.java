package com.ndemaio.ejercicioaseguradorahql.service;

import com.ndemaio.ejercicioaseguradorahql.model.Siniestro;
import com.ndemaio.ejercicioaseguradorahql.repository.SiniestroRepository;
import com.ndemaio.ejercicioaseguradorahql.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SiniestroService {

    @Autowired
    private SiniestroRepository siniestroRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public void createSiniestros() {

        var vehiculos = vehiculoRepository.findAll();

        vehiculos.forEach(vehiculo -> {
            siniestroRepository.save(new Siniestro(1l, LocalDate.now(), 12000d, vehiculo));
        });
    }

    public void deleteById(Long anId) {
        siniestroRepository.deleteById(anId);
    }
}
