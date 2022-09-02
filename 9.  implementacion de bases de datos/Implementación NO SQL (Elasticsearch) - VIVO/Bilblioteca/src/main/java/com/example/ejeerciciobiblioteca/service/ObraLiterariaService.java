package com.example.ejeerciciobiblioteca.service;


import com.example.ejeerciciobiblioteca.dto.ObraLiterariaDto;
import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;
import com.example.ejeerciciobiblioteca.repository.IObraLiterariaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    IObraLiterariaRepository obraRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void createObraLiteraria(ObraLiterariaDto obra) {
        ObraLiteraria nuevaObra = mapper.convertValue(obra,ObraLiteraria.class);
        obraRepository.save(nuevaObra);
    }

    @Override
    public List<ObraLiterariaDto> getAllObraLiterarias() {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findAll().forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }
    @Override
    public List<ObraLiterariaDto> getAllObraLiterariasPorAutor(String autor) {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findObraLiterariaByAutor(autor).forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }

    @Override
    public List<ObraLiterariaDto> getAllObraLiterariaByNombreLike(String nombre) {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findObraLiterariaByNombreLike(nombre).forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }

    @Override
    public List<ObraLiterariaDto> getAllObraLiterariaByCantPaginasGreaterThan(Integer paginas) {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findObraLiterariaByCantPaginasGreaterThan(paginas).forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }

    @Override
    public List<ObraLiterariaDto> getAllObraLiterariaByAnioPublicacionGreaterThan(Integer despues) {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findObraLiterariaByAnioPublicacionGreaterThan(despues).forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }

    @Override
    public List<ObraLiterariaDto> getAllObraLiterariaByAnioPublicacionLessThan(Integer antes) {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findObraLiterariaByAnioPublicacionLessThan(antes).forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }

    @Override
    public List<ObraLiterariaDto> getAllObraLiterariaByEditorialLike(String editorial) {
        List<ObraLiterariaDto> returnList = new ArrayList<>();
        obraRepository.findObraLiterariaByEditorialLike(editorial).forEach(x->returnList.add(mapper.convertValue(x,ObraLiterariaDto.class)));
        return returnList;
    }

}
