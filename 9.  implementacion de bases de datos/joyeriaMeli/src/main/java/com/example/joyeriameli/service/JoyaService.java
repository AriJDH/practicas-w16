package com.example.joyeriameli.service;

import com.example.joyeriameli.dto.MessageDto;
import com.example.joyeriameli.model.Joya;
import com.example.joyeriameli.repository.IJoyaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepository;

    //Si implemento con constructor es así:
    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public List<Joya> getJoya() {
        List<Joya> joyaList = joyaRepository
                .findAll()
                .stream()
                .filter(x-> x.getVentaONo())
                .collect(Collectors.toList());
        return joyaList;
    }

    @Override
    @Transactional
    public MessageDto saveJoya(Joya joya) {
        this.joyaRepository.save(joya);
        return new MessageDto("Joya creada correctamente", joya.getNro_identificatorio(), joya);
    }

    @Override
    @Transactional
    public MessageDto deleteJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joyaRepository.deleteById(id);
        MessageDto messageDto = new MessageDto("La joya con id " + id + " ha sido eliminada de BD (NO LOGICAMENTE)", joya);
        return messageDto;
    }
    @Override
    @Transactional
    public MessageDto deleteJoyaLogic(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setVentaONo(false);
        MessageDto messageDto = new MessageDto("La joya con id " + id + " ha sido eliminada LOGICAMENTE", joya);
        return messageDto;
    }
    @Override
    @Transactional
    public MessageDto findJoya(Long id) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        MessageDto messageDto;
        messageDto = new MessageDto("Se ha encontrado la joya", joya);
        return messageDto;
    }
    @Override
    @Transactional
    public MessageDto updateJoya(Long id,String newName,Long newPeso) {
        Joya joya = joyaRepository.findById(id).orElse(null);
        joya.setNombre(newName);
        joya.setPeso(newPeso);
        joyaRepository.save(joya);
        MessageDto messageDto;
        messageDto = new MessageDto("Se ha modificado la joya con id: "+id, joya);
        return messageDto;
    }


}
