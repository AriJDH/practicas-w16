package com.example.elastic.mapper;

import com.example.elastic.dto.ObraDTO;
import com.example.elastic.model.ObrasLiterarias;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {

    public List<ObrasLiterarias> obraDtoToObraEntity(List<ObraDTO> obraDto){

        return obraDto.stream().map(x->{

            ObrasLiterarias obrasLiterarias = new ObrasLiterarias();
            obrasLiterarias.setNombre(x.getNombre());
            obrasLiterarias.setAutor(x.getAutor());
            obrasLiterarias.setEditorial(x.getEditorial());
            obrasLiterarias.setAnioPublicacion(x.getAnioPublicacion());
            obrasLiterarias.setPaginas(x.getPaginas());

            return obrasLiterarias;

        }).collect(Collectors.toList());

    }

    public List<ObraDTO> ObraEntityToObraDto(List<ObrasLiterarias> obras) {

        return obras.stream().map(x->{

            ObraDTO obraDTO = new ObraDTO();
            obraDTO.setId(x.getId());
            obraDTO.setNombre(x.getNombre());
            obraDTO.setAutor(x.getAutor());
            obraDTO.setEditorial(x.getEditorial());
            obraDTO.setAnioPublicacion(x.getAnioPublicacion());
            obraDTO.setPaginas(x.getPaginas());

            return obraDTO;

        }).collect(Collectors.toList());

    }

}
