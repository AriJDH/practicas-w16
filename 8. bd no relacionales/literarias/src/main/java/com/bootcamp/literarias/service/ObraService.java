package com.bootcamp.literarias.service;

import com.bootcamp.literarias.dto.ObraDto;
import com.bootcamp.literarias.entity.Obra;
import com.bootcamp.literarias.repository.IObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraService implements IObraService {

    @Autowired
    IObraRepository obraRepository;

    @Override
    public ObraDto create(ObraDto obraDto) {
        Obra obra = new Obra(obraDto.getNombre(), obraDto.getAutor(), obraDto.getCantidadPaginas(), obraDto.getEditorial(), obraDto.getAnioPublicacion());
        Obra result = obraRepository.save(obra);

        return new ObraDto(result.getId(), result.getNombre(), result.getAutor(), result.getCantidadPaginas(), result.getEditorial(), result.getAnioPublicacion());
    }

    @Override
    public List<ObraDto> getNombreAutor(String nombre) {
        List<ObraDto> list = new ArrayList<>();
        obraRepository.getNombreAutor(nombre).forEach(o -> list.add(new ObraDto(o.getId(),o.getNombre(), o.getAutor(), o.getCantidadPaginas(), o.getEditorial(), o.getAnioPublicacion())));

        return list;
    }

    @Override
    public List<ObraDto> getNombreObra(String nombre) {
        return null;
    }

    @Override
    public List<ObraDto> getObrasCantidadByPaginas(Integer pages) {
        return null;
    }

    @Override
    public List<ObraDto> getObrasAntesByAnio(String fecha) {
        return null;
    }

    @Override
    public List<ObraDto> getObrasDespuesByAnio(String fecha) {
        return null;
    }

    @Override
    public List<ObraDto> getObrasEditorial(String editorial) {
        return null;
    }
}
