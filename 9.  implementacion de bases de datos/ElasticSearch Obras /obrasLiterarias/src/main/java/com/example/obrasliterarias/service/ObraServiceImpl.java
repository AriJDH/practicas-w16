package com.example.obrasliterarias.service;

import com.example.obrasliterarias.dto.ObraConIdDto;
import com.example.obrasliterarias.dto.ObraDto;
import com.example.obrasliterarias.model.ObraLiteraria;
import com.example.obrasliterarias.repository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ObraServiceImpl implements IObraServicio{

    @Autowired
    IObrasRepository repository;

    ModelMapper mapper;

    public ObraServiceImpl() {
        this.mapper = new ModelMapper();
    }

    @Override
    public ObraConIdDto crearObras(ObraDto obraDto) {
        ObraLiteraria obra = repository.save(mapper.map(obraDto,ObraLiteraria.class));
        return mapper.map(obra,ObraConIdDto.class);
    }

    @Override
    public List<ObraConIdDto> listarPorNombre(String nombre){
        return repository.findObrasByAutor(nombre).stream()
                .map(obraLiteraria -> mapper.map(obraLiteraria,ObraConIdDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<ObraConIdDto> listarPorPalabra(String nombre) {
        return repository.findObrasByWord(nombre).stream()
                .map(obraLiteraria -> mapper.map(obraLiteraria,ObraConIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<ObraConIdDto> listarTodas() {
        Iterable<ObraLiteraria> obras = repository.findAll();
        List<ObraLiteraria> obraLiterariasList = new ArrayList<>();
        obras.forEach(obraLiterariasList::add);
        List<ObraConIdDto>obrasDtoList = obraLiterariasList.stream()
                .map(employee -> mapper.map(employee,ObraConIdDto.class)).collect(Collectors.toList());
        return obrasDtoList;
    }

    @Override
    public List<ObraConIdDto> listarPorPaginas(Integer cantidad) {
        return repository.findPages(cantidad).stream()
                .map(obraLiteraria -> mapper.map(obraLiteraria,ObraConIdDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraConIdDto> listarPorEditorial(String editorial) {
        return repository.findByEditorial(editorial).stream()
                .map(obraLiteraria -> mapper.map(obraLiteraria,ObraConIdDto.class))
                .collect(Collectors.toList());
    }
}
