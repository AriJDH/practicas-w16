package com.bootcamp.elastic.service;

import com.bootcamp.elastic.DTO.ObraDTO;
import com.bootcamp.elastic.model.Obra;
import com.bootcamp.elastic.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService implements IObraService{
    @Autowired
    IObraRepository iObraRepository;

    private final ModelMapper mapper;

    public ObraService(){
        mapper=new ModelMapper();
    }

    @Override
    public String saveObra(ObraDTO obraDTO) {
        Obra obra=mapper.map(obraDTO,Obra.class);
        iObraRepository.save(obra);
        return "Registro creado!";
    }

    @Override
    public List<ObraDTO> findByAutor(String autor) {
        return iObraRepository.findByAutor(autor).stream()
                .map(obra -> mapper.map(obra, ObraDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDTO> findByTitulo(String nombre) {
        return iObraRepository.findByTitulo(nombre).stream()
                . //ojo buscar esto
                .map(obra -> mapper.map(obra, ObraDTO.class))
                .collect(Collectors.toList());
    }
}
