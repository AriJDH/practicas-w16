package com.example.lasperlas.service;

import com.example.lasperlas.dtos.JoyaDto;
import com.example.lasperlas.dtos.MessageDto;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final ModelMapper mapper;
    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
        mapper = new ModelMapper();
    }

    @Override
    @Transactional
    public MessageDto saveJoya(JoyaDto joyaDto) {
        Joya joya = mapper.map(joyaDto, Joya.class);
        joya.setVentaONo(true);
        joyaRepository.save(joya);
        return new MessageDto("La joya fue guardada con número identificatorio: " + joya.getNro_identificatorio());
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDto> getJoyas() {
        return joyaRepository.findAll().stream().filter(joya -> joya.isVentaONo())
                .map(joya -> mapper.map(joya, JoyaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageDto deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setVentaONo(false);
        joyaRepository.save(joya);

        return new MessageDto("La joya fue dada de baja correctamente");
    }

    @Override
    @Transactional
    public Object updateJoya(Long id, JoyaDto joyaDTO) {
        Joya joya = joyaRepository.findById(id).orElse(null);

        if (joya != null) {
            joya.setNombre(joyaDTO.getNombre());
            joya.setMaterial(joyaDTO.getMaterial());
            joya.setPeso(joyaDTO.getPeso());
            joya.setParticularidad(joyaDTO.getParticularidad());
            joya.setPosee_piedra(joyaDTO.isPosee_piedra());

            joyaRepository.save(joya);

            return mapper.map(joya, JoyaDto.class);
        }
        else
            return new MessageDto("No existe la joya");
    }
}
