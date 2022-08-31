package com.myapp.lasperlas.services;

import com.myapp.lasperlas.dto.JoyaDTO;
import com.myapp.lasperlas.model.Joya;
import com.myapp.lasperlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    private final ModelMapper mapper;

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
        mapper = new ModelMapper();
    }


    @Override
    public String saveJoya(JoyaDTO joyaDTO) {
        Joya joya = mapper.map(joyaDTO, Joya.class);
        joyaRepository.save(joya);
        return "La joya " + joya.getNroIdentificatorio() + " fue guardada exitosamente";
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDTO> getAll() {
        return joyaRepository.findAll().stream()
                .filter(Joya::getVentaONo)
                .map(joya -> mapper.map(joya, JoyaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(Long nroIdentificatorio) {
        Joya joya = joyaRepository.findById(nroIdentificatorio).orElse(null);
        joya.setVentaONo(false);
        joyaRepository.save(joya);
        
        return "La joya fue dada de baja correctamente";
    }

    @Override
    @Transactional(readOnly = true)
    public JoyaDTO getById(Long nroIdentificatorio) {
        return mapper.map(joyaRepository.findById(nroIdentificatorio).orElse(null), JoyaDTO.class);
    }

    @Override
    public String updateJoya(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);

        joya.setNombre(joyaDTO.getNombre());
        joya.setMaterial(joyaDTO.getMaterial());
        joya.setPeso(joyaDTO.getPeso());
        joya.setParticularidad(joyaDTO.getParticularidad());
        joya.setPoseePiedra(joyaDTO.getPoseePiedra());

        joyaRepository.save(joya);

        return "Modificado correctamente";


    }
}
