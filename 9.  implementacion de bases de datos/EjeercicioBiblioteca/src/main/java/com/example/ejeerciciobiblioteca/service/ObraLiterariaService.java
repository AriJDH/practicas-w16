package com.example.ejeerciciobiblioteca.service;


import com.example.ejeerciciobiblioteca.dto.ObraLiterariaDto;
import com.example.ejeerciciobiblioteca.entity.ObraLiteraria;
import com.example.ejeerciciobiblioteca.repository.IObraLiterariaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<ObraLiterariaDto> buscarPorAutor(String nombre) {
        return obraRepository.findByAutorEqualsIgnoreCase(nombre).stream().map(x->mapper.convertValue(x,ObraLiterariaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDto> buscarPorNombre(String nombre) {
        return obraRepository.findByNombreContainsIgnoreCase(nombre).stream().map(x->mapper.convertValue(x,ObraLiterariaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDto> buscarConCantPaginasMasQue(Integer cantPaginas){
    return obraRepository.findByCantDePaginasIsGreaterThan(cantPaginas).stream().map(x->mapper.convertValue(x,ObraLiterariaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDto> buscarConAnioMenorA(Integer anio) {
        return obraRepository.findByAnioPrimeraPublicacionIsLessThan(anio).stream().map(x->mapper.convertValue(x,ObraLiterariaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDto> buscarConAnioMayorA(Integer anio) {
        return obraRepository.findByAnioPrimeraPublicacionIsGreaterThan(anio).stream().map(x->mapper.convertValue(x,ObraLiterariaDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObraLiterariaDto> buscarPorEditorial(String editorial) {
        return obraRepository.findByEditorialEqualsIgnoreCase(editorial).stream().map(x->mapper.convertValue(x,ObraLiterariaDto.class)).collect(Collectors.toList());
    }
}
