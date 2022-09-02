package com.example.ejerciciosiniestros.service;

import com.example.ejerciciosiniestros.dto.SiniestroDTO;
import com.example.ejerciciosiniestros.model.Siniestro;
import com.example.ejerciciosiniestros.repository.ISiniestroRepository;
import com.example.ejerciciosiniestros.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroService implements ISiniestroService {

    ISiniestroRepository siniestroRepository;
    IVehiculoRepository vehiculoRepository;

    public SiniestroService(ISiniestroRepository SiniestroRepository, IVehiculoRepository vehiculoRepository) {
        this.siniestroRepository = SiniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    public Siniestro findSiniestroById(long id) {
        return siniestroRepository.findById(id).orElse(null);
    }

    @Override
    public List<Siniestro> findAllSiniestros() {
        return siniestroRepository.findAll();
    }

    public Siniestro saveSiniestro(SiniestroDTO siniestroDTO) {
        Siniestro siniestro = new Siniestro(siniestroDTO.getFechaSiniestro(), siniestroDTO.getPerdidaEconomica(), vehiculoRepository.findById(siniestroDTO.getVehiculoId()).orElse(null));
        return siniestroRepository.save(siniestro);
    }

    public void deleteSiniestro(long id) {
        siniestroRepository.deleteById(id);
    }

    public Siniestro updateSiniestro(Siniestro siniestro) {
        return siniestroRepository.save(siniestro);
    }
}
