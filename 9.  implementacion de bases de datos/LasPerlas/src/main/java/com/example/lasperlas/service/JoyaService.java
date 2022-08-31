package com.example.lasperlas.service;

import com.example.lasperlas.dto.JoyaDto;
import com.example.lasperlas.exception.JoyaNotFoundException;
import com.example.lasperlas.model.Joya;
import com.example.lasperlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyaService implements IJoyaService {

    IJoyaRepository repo;
    ModelMapper mapper;

    public JoyaService(IJoyaRepository repo) {
        this.repo = repo;
        mapper = new ModelMapper();
    }

    @Override
    public List<JoyaDto> listAll() {
        return repo.findAll().stream()
                .filter(Joya::isVenta)
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public JoyaDto create(JoyaDto dto) {
        Joya entity = toEntity(dto);
        entity.setNroIdentificatorio(null);
        entity.setVenta(true);
        return toDto(repo.save(entity));
    }

    @Override
    public JoyaDto update(JoyaDto dto, Long id) {
        Joya joya = repo.findById(id).orElse(null);
        if(joya == null || !joya.isVenta())
            throw new JoyaNotFoundException(id);
        joya = toEntity(dto);
        joya.setNroIdentificatorio(id);
        joya.setVenta(true);
        return toDto(repo.save(joya));
    }

    @Override
    public void delete(Long id) {
        Joya joya = repo.findById(id).orElse(null);
        if(joya == null || !joya.isVenta())
            throw new JoyaNotFoundException(id);
        joya.setVenta(false);
        repo.save(joya);
    }

    private JoyaDto toDto(Joya entity) {
        return mapper.map(entity, JoyaDto.class);
    }

    private Joya toEntity(JoyaDto dto) {
        return mapper.map(dto, Joya.class);
    }
}
