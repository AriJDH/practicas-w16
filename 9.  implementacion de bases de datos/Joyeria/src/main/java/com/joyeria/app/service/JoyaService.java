package com.joyeria.app.service;

import com.joyeria.app.dto.JoyaDto;
import com.joyeria.app.model.Joya;
import com.joyeria.app.repository.IJoyaRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    @Autowired
    private IJoyaRepository joyaRepository;

    @Override
    public JoyaDto save(Joya joya) {
        Joya joyaSave = joyaRepository.save(joya);

        return convertToDto(joyaSave);
    }

    @Override
    public void delete(Long id) throws Exception {
        Joya joya = joyaRepository.findById(id).orElse(null);
        if(joya == null) throw new Exception("Joya no encontrada");
        joya.setVentaONo(false);
        joyaRepository.save(joya);
    }

    @Override
    public List<JoyaDto> getJoyas() {
        return joyaRepository.findAll()
                .stream()
                .filter(j -> j.isVentaONo()==true)
                .map( joya -> new JoyaDto(joya.getNombre(),joya.getMaterial(),joya.getPeso(),joya.getParticularidad(),joya.isPoseePiedra(),joya.isVentaONo()))
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDto getJoyaById(Long id) {
        return convertToDto(joyaRepository.findById(id).orElse(null));
    }

    @Override
    public JoyaDto update(Long id,Joya joya) throws Exception {
        Joya joyaToUpdate = joyaRepository.findById(id).orElse(null);

        if(joya == null) throw new Exception("Joya no encontrada");
        joya.setId(joyaToUpdate.getId());
        joyaRepository.save(joya);
        return convertToDto(joya);
    }

    private JoyaDto convertToDto(Joya joya){
        ModelMapper mapper = new ModelMapper();
        JoyaDto joyaDto = mapper.map(joya,JoyaDto.class);
        if (joyaDto != null) return joyaDto;
        return null;
    }
}
