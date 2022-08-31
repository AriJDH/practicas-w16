package com.example.joyeria.service;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.JoyaUpdateDTO;
import com.example.joyeria.exceptions.IdError;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImp implements JoyaService{
    final JoyaRepository repo;

    ModelMapper mapper = new ModelMapper();

    public JoyaServiceImp(JoyaRepository repo) {
        this.repo = repo;
    }
    @Override
    public String createNewJoya(JoyaDTO joyaDTO) {
        Joya joya = new Joya(joyaDTO.getNombre(),joyaDTO.getMaterial(),joyaDTO.getPeso(),joyaDTO.getParticularidad(),joyaDTO.isPosee_piedra(),joyaDTO.isVentaONo());
                try {
            repo.save(joya);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Numero identificatorio :"+repo.count();
    }
    @Override
    public List<JoyaUpdateDTO> getAll(){
        List<Joya> list = repo.findAll();
        return list.stream()
                .filter(Joya::isVentaONo)
                .map(joya ->mapper.map(joya,JoyaUpdateDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public JoyaDTO getById(int id)throws IdError {
        if (!repo.existsById(id)) throw new IdError();
        Joya joya = repo.findById(id).get();
        return mapper.map(joya,JoyaDTO.class);
    }
    @Override
    public String deleteById(int id) throws IdError {
        if (!repo.existsById(id)) throw new IdError();
        Joya joya = repo.findById(id).get();
        joya.setVentaONo(false);
        repo.save(joya);
        return "Joya deleted";
    }

    @Override
    public JoyaUpdateDTO updateById(int id, JoyaUpdateDTO joyaUpdateDTO) throws IdError {
        if (!repo.existsById(id)) throw new IdError();
        Joya joya = repo.findById(id).get();
        joya.setNombre(joyaUpdateDTO.getNombre());
        joya.setMaterial(joyaUpdateDTO.getMaterial());
        joya.setParticularidad(joyaUpdateDTO.getParticularidad());
        joya.setPosee_piedra(joyaUpdateDTO.isPosee_piedra());
        joya.setVentaONo(joyaUpdateDTO.isVentaONo());
        repo.save(joya);
        return mapper.map(joya,JoyaUpdateDTO.class);
    }
}
