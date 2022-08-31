package com.bootcamp.joyeria.service;

import com.bootcamp.joyeria.dto.JoyaDto;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class JoyaService implements IJoyaService {

    @Autowired
    JoyaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Joya> getJoyas() {
        return repository.findAll();
    }

    @Override
    public void saveJoya(JoyaDto joya) {
        repository.save(mapperDtoToEntity(joya));
    }

    @Override
    public void deleteJoyaBy(Long id) {
        Joya joya = findJoyaById(id);
        if(joya == null)
            throw new RuntimeException("La joya no se encuentra");
        if(joya.getVentaONo())
            throw new RuntimeException("La joya esta a la venta para eliminarla debes quitarla de la venta");

        repository.deleteById(id);
    }

    @Override
    public Joya findJoyaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Joya UpdateJoyaById(Long id, JoyaDto dto) {
        Joya joya = findJoyaById(id);
        if(joya == null)
            throw new RuntimeException("La joya no se encuentra");
        joya.setPeso(dto.getPeso());
        joya.setMaterial(dto.getMaterial());
        joya.setNombre(dto.getNombre());
        joya.setVentaONo(dto.getVentaONo());
        joya.setParticularidad(dto.getParticularidad());
        joya.setPosee_piedra(dto.getPosee_piedra());
        repository.save(joya);
        return joya;
    }

    private Joya mapperDtoToEntity(JoyaDto dto)
    {
        return new Joya(0L, dto.getNombre(), dto.getMaterial(), dto.getPeso(),dto.getParticularidad(), dto.getPosee_piedra(),dto.getVentaONo());
    }
}
