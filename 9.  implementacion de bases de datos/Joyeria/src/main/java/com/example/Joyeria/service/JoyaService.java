package com.example.Joyeria.service;

import com.example.Joyeria.Mapper;
import com.example.Joyeria.dto.JoyaDTO;
import com.example.Joyeria.dto.MessageDTO;
import com.example.Joyeria.model.Joya;
import com.example.Joyeria.repository.JoyaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService{

    private final JoyaRepository joyaRepo;
    private Mapper mapper;

    public JoyaService(JoyaRepository joyaRepo){
        this.joyaRepo = joyaRepo;
        this.mapper = new Mapper();
    }

    @Override
    public MessageDTO saveJoya(Joya j) {
        Integer id = joyaRepo.save(j).getNro_identificatorio();
        return new MessageDTO("La joya fue guardada correctamente, nro identificatorio: " + id);
    }

    @Override
    public List<JoyaDTO> getJoyas() {
        return joyaRepo.findAll()
                .stream()
                .filter(x -> x.isVentaONo())
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteJoya(int id) {
        Joya j_db = joyaRepo.findById(id).orElse(null);
        j_db.setVentaONo(false);
        joyaRepo.save(j_db);
        return new MessageDTO("La joya fue eliminada correctamente.");
    }

    @Override
    public JoyaDTO editJoya(int id, JoyaDTO j) {
        Joya j_db = joyaRepo.findById(id).orElse(null);
        j_db.update(j);
        return mapper.toDTO(joyaRepo.save(j_db));
    }
}
