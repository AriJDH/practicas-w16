package com.miniseries.services;

import com.miniseries.dto.JoyaDTO;
import com.miniseries.entities.Joya;
import com.miniseries.repositories.IJoyaRepository;
import com.miniseries.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceimpl implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    @Autowired
    public JoyaServiceimpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public JoyaDTO create(JoyaDTO joyaDTO) {
        joyaRepository.save(Mapper.parseJoyaFromJoyaDTOWithoutId(joyaDTO));
        return joyaDTO;
    }

    @Override
    public JoyaDTO findById(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        assert joya != null;
        return Mapper.parseJoyaDTOFromJoya(joya);
    }

    @Override
    public List<JoyaDTO> find() {
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream().map(Mapper::parseJoyaDTOFromJoya)
                .filter(JoyaDTO::isVentaONo)
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDTO delete(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if (joya != null) {
            joya.setVenta_o_no(false);
            joyaRepository.save(joya);
        }
        return Mapper.parseJoyaDTOFromJoya(joya);
    }

    @Override
    public JoyaDTO update(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if (joya != null) {
            joyaDTO.setId(joya.getId());
            Joya newJoya = Mapper.parseJoyaFromJoyaDTOWithtId(joyaDTO);
            joyaRepository.save(newJoya);
        }
        return joyaDTO;
    }
}
