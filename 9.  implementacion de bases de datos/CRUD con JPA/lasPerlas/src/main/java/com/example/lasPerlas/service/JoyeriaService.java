package com.example.lasPerlas.service;

import com.example.lasPerlas.dto.JoyaDTO;
import com.example.lasPerlas.entity.Joya;
import com.example.lasPerlas.repository.IJoyeriaRepository;
import com.example.lasPerlas.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyeriaService implements  IJoyeriaService {

    private final IJoyeriaRepository joyaRepo;

    public JoyeriaService(IJoyeriaRepository joyaRepo) {

        this.joyaRepo = joyaRepo;
    }

    @Override
    public List<JoyaDTO> find() {
        List<Joya> joyas = joyaRepo.findAll();
        return joyas.stream().map(Mapper::mapperJoyatoJoyaDto)
                .filter(JoyaDTO::isVentaONo)
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDTO deleteJoya(Long id) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        if(joya!=null){
            joya.setVentaONo(false);
            joyaRepo.save(joya);
        }
        return Mapper.mapperJoyatoJoyaDto(joya);
    }

    @Override
    public JoyaDTO findJoyaById(Long id) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        JoyaDTO joyaDTO = new JoyaDTO();
        if(joya!= null){
            joyaDTO = Mapper.mapperJoyatoJoyaDto(joya);
        }
        return joyaDTO;
    }

    @Override
    public JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO) {
        Joya joya = joyaRepo.findById(id).orElse(null);
        if(joya!=null){
            joyaDTO.setNro_identificatorio(joya.getNro_identificatorio());
            Joya nueva = Mapper.mapperJoyaDTOtoJoyaWithId(joyaDTO);
            joyaRepo.save(nueva);
        }
        return joyaDTO;
    }


    @Override
    public JoyaDTO createJoya(JoyaDTO joyaDTO) {
        Joya joya = Mapper.mapperJoyaDTOtoJoya(joyaDTO);
        joyaRepo.save(joya);
        return joyaDTO;
    }
}

