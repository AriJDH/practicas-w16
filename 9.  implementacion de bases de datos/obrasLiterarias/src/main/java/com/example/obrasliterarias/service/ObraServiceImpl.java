package com.example.obrasliterarias.service;

import com.example.obrasliterarias.dto.ObraConIdDto;
import com.example.obrasliterarias.dto.ObraDto;
import com.example.obrasliterarias.exception.ObraNotFoundException;
import com.example.obrasliterarias.model.ObraLiteraria;
import com.example.obrasliterarias.repository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ObraServiceImpl implements IObraServicio{

    final
    IObrasRepository repository;

    ModelMapper mapper;

    public ObraServiceImpl(IObrasRepository repository) {
        this.mapper = new ModelMapper();
        this.repository = repository;
    }

    @Override
    public ObraConIdDto crearObra(ObraDto obraDto) {
        ObraLiteraria obra = repository.save(mapper.map(obraDto,ObraLiteraria.class));
        return mapper.map(obra,ObraConIdDto.class);
    }

    @Override
    public List<ObraConIdDto> listarObras() {
        List<ObraConIdDto> response = new ArrayList<>();
        repository.findAll()
                .forEach(ol -> response.add(mapper.map(ol, ObraConIdDto.class)));
        return response;
    }

    @Override
    public ObraConIdDto modificarObra(ObraConIdDto obraDto) {
        if(!repository.existsById(obraDto.getId()))
            throw new ObraNotFoundException(obraDto.getId());
        ObraLiteraria obra = repository.save(mapper.map(obraDto, ObraLiteraria.class));
        return mapper.map(obra, ObraConIdDto.class);
    }

    @Override
    public void eliminarObra(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<ObraConIdDto> findByAutor(String autor) {
        return mapListToDto(repository.findByAutor(autor));
    }

    @Override
    public List<ObraConIdDto> findByNombreContaining(String nombre) {
        return mapListToDto(repository.findByNombreContaining(nombre));
    }

    @Override
    public List<ObraConIdDto> findByCantPaginasGreaterThan(Integer cant) {
        return mapListToDto(repository.findByCantPaginasGreaterThan(cant));
    }

    @Override
    public List<ObraConIdDto> findByFechaPublicacionBefore(Date fecha) {
        return mapListToDto(repository.findByFechaPublicacionBefore(fecha));
    }

    @Override
    public List<ObraConIdDto> findByFechaPublicacionAfter(Date fecha) {
        return mapListToDto(repository.findByFechaPublicacionAfter(fecha));
    }

    @Override
    public List<ObraConIdDto> findByEditorial(String editorial) {
        return mapListToDto(repository.findByEditorial(editorial));
    }

    private List<ObraConIdDto> mapListToDto(List<ObraLiteraria> obras) {
        return obras.stream()
                .map(ol -> mapper.map(ol, ObraConIdDto.class))
                .collect(Collectors.toList());
    }
}
