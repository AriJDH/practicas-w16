package com.joyeria.lasperlas.service;

import com.joyeria.lasperlas.DTOs.JoyaDTO;
import com.joyeria.lasperlas.DTOs.JoyaUpdateDTO;
import com.joyeria.lasperlas.Entity.Joya;
import com.joyeria.lasperlas.repository.IJoyaDAO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService {


    private final IJoyaDAO joyaDAO;
    private final ModelMapper modelMapper;

    public JoyaServiceImpl(IJoyaDAO joyaDAO) {
        this.joyaDAO = joyaDAO;
        this.modelMapper = new ModelMapper();
    }


    public Long create(JoyaDTO joyaCreateDTO) {
        Joya joya = joyaDAO.save(modelMapper.map(joyaCreateDTO, Joya.class));

        return joya.getNro_identificatorio();
    }

    public List<JoyaDTO> getAll() {

        return joyaDAO.findAll()
                .stream()
                .filter(joya -> !joya.getVendido())
                .map(joya -> modelMapper.map(joya, JoyaDTO.class))
                .collect(Collectors.toList());
    }

    public boolean delete(Long id) {
        Joya joyaById = joyaDAO.findById(id).orElse(null);
        assert joyaById != null;
        joyaById.setVendido(true);

        joyaDAO.save(joyaById);
        return true;
    }

    public JoyaUpdateDTO update(JoyaDTO joyaDTO, Long id) {
        Joya joyaById = joyaDAO.findById(id).orElse(null);
        assert joyaById != null;

        joyaById.setNombre(joyaDTO.getNombre());
        joyaById.setMaterial(joyaDTO.getMaterial());
        joyaById.setParticularidad(joyaDTO.getParticularidad());
        joyaById.setPeso(joyaDTO.getPeso());
        joyaById.setPosee_piedra(joyaDTO.getPosee_piedra());

        Joya result = joyaDAO.save(joyaById);
        return modelMapper.map(result, JoyaUpdateDTO.class);
    }

}
