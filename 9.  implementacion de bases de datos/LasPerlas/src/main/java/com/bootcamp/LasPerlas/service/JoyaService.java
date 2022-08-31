package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.repository.IJoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository joyaRepository;

    @Override
    public String saveJoya(Joya joya) {
       joyaRepository.save(joya);

       return "Joya guardada correctamente";
    }

    @Override
    public List<Joya> getJoyas() {
        return joyaRepository.findAll();
    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteJoya(Long id) {
        Joya joyaOriginal = this.findJoya(id);
        joyaOriginal.setVentaONo(false);
        this.saveJoya(joyaOriginal);

        return "Joya ID:"+id+" dada de baja para la venta correctamente";
    }

    @Override
    public String modifyJoya(Long id, Joya joya_modif) {
        Joya joyaOriginal = this.findJoya(id);

        joyaOriginal.setNombre(joya_modif.getNombre());
        joyaOriginal.setMaterial(joya_modif.getMaterial());
        joyaOriginal.setPeso(joya_modif.getPeso());
        joyaOriginal.setParticularidad(joya_modif.getParticularidad());
        joyaOriginal.setPosee_piedra(joya_modif.isPosee_piedra());
        joyaOriginal.setVentaONo(joya_modif.isVentaONo());

        this.saveJoya(joyaOriginal);
        return "Joya ID:"+id+" modificada correctamente";
    }
}
