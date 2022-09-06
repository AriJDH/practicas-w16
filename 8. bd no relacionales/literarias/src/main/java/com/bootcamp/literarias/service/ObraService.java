package com.bootcamp.literarias.service;

import com.bootcamp.literarias.dto.ObraDto;
import com.bootcamp.literarias.entity.Obra;
import com.bootcamp.literarias.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService implements IObraService {

    @Autowired
    IObraRepository obraRepository;

    private final ModelMapper modelMapper;

    public ObraService() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ObraDto create(ObraDto obraDto) {

        Obra result = obraRepository.save(modelMapper.map(obraDto, Obra.class));

        return modelMapper.map(result, ObraDto.class);
    }

   @Override
    public List<ObraDto> findByAutor(String nombre) {

        return obraRepository.findByAutor(nombre)
                .stream()
                .map(o -> modelMapper.map(o, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
     public List<ObraDto> findByObraContaining(String nombre) {

        return obraRepository.findByNombreContaining(nombre)
                .stream()
                .map(o -> modelMapper.map(o, ObraDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<ObraDto> findByCantidadPaginasGreaterThan(Integer pages) {
        return obraRepository.findByCantidadPaginasGreaterThan(pages)
                .stream()
                .map(o -> modelMapper.map(o, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByAnioPublicacionLessThanEqual(Integer anio) {
        return obraRepository.findByAnioPublicacionLessThanEqual(anio)
                .stream()
                .map(o -> modelMapper.map(o, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByAnioPublicacionGreaterThanEqual(Integer anio) {
        return obraRepository.findByAnioPublicacionGreaterThanEqual(anio)
                .stream()
                .map(o -> modelMapper.map(o, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findByEditorial(String editorial) {
        return obraRepository.findByEditorial(editorial)
                .stream()
                .map(o -> modelMapper.map(o, ObraDto.class))
                .collect(Collectors.toList());
    }
}
