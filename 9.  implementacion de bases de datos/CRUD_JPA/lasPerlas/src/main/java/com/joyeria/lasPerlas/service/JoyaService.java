package com.joyeria.lasPerlas.service;
import com.joyeria.lasPerlas.service.IJoyaService;
import com.joyeria.lasPerlas.model.Joya;
import com.joyeria.lasPerlas.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaService implements IJoyaService {

    @Autowired
    JoyaRepository joyaRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        List<Joya> joyasList = joyaRepository.findAllByVentaONoIsTrue();
        return joyasList;
    }

    @Override
    @Transactional()
    public Long saveJoya(Joya joya) {
        joya.setVentaONo(true);
        joyaRepository.save(joya);
        return joya.getNro_identificatorio();
    }

    @Override
    @Transactional()
    public void deleteJoya(Long id) {
        Joya joya = findJoyaById(id);
        joya.setVentaONo(false);
        joyaRepository.save(joya);
    }

    @Override
    @Transactional()
    public Joya findJoyaById(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        return joya;
    }

    @Override
    @Transactional()
    public Joya updateJoya(Long id, String nombre, String material, Double gramos, String particularidad, Boolean posee_piedra) {
        Joya joya = findJoyaById(id);
        joya.setNombre(nombre);
        joya.setMaterial(material);
        joya.setGramos(gramos);
        joya.setParticularidad(particularidad);
        joya.setPosee_piedra(posee_piedra);
        joyaRepository.save(joya);
        return joya;
    }
}
