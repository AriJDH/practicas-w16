package com.example.joyas.service;

import com.example.joyas.dto.JoyaDto;
import com.example.joyas.dto.MensajeDto;
import com.example.joyas.model.Joya;
import com.example.joyas.repository.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JoyaDto> getAllJewerly() {
        List<JoyaDto> joyaDtoList = joyaRepository.findAll().stream().filter(joya -> joya.getVentaONo()==Boolean.TRUE)
                .map(joya -> new JoyaDto(joya.getNroIdentificatorio(),joya.getNombre(), joya.getMaterial(), joya.getPeso(), joya.getParticularidad(),
                        joya.getPoseePiedra(), joya.getVentaONo())).collect(Collectors.toList());
        return joyaDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public JoyaDto getJewerlyById(Long id) {

        Joya joya = joyaRepository.findById(id).orElse(null);
        JoyaDto joyaDto = new JoyaDto(joya.getNombre(), joya.getMaterial(), joya.getPeso(),
                joya.getParticularidad(), joya.getPoseePiedra(), joya.getVentaONo());
        return joyaDto;
    }

    @Override
    public MensajeDto saveJewerly(JoyaDto joyaDto) {
        Joya joya = joyaRepository.save(new Joya(joyaDto.getNombre(), joyaDto.getMaterial(), joyaDto.getPeso(),
                joyaDto.getParticularidad(), joyaDto.getPoseePiedra(), joyaDto.getVentaONo()));
        return new MensajeDto("El número identificatorio de la joya es :" + joya.getNroIdentificatorio());
    }

    @Override
    public JoyaDto updateJoya(JoyaDto joyaDto,Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.getPoseePiedra());
        joya.setVentaONo(joyaDto.getVentaONo());
        joyaRepository.save(joya);
        return new JoyaDto(joya.getNroIdentificatorio(),joya.getNombre(),joya.getMaterial(),joya.getPeso(),joya.getParticularidad(),
                joya.getPoseePiedra(),joya.getVentaONo());
    }
    
    @Override
    public void deleteJewerly(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setVentaONo(Boolean.FALSE);
        joyaRepository.save(joya);

    }


}

