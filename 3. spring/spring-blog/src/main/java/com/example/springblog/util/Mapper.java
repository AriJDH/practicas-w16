package com.example.springblog.util;

import com.example.springblog.dto.EntradaBlogDTO;
import com.example.springblog.model.EntradaBlog;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public static EntradaBlog toEntradaBlog(EntradaBlogDTO entradaBlogDTO) {
        return new EntradaBlog(entradaBlogDTO.getId(), entradaBlogDTO.getTitulo(), entradaBlogDTO.getNombreDelAutor(), entradaBlogDTO.getFecha());
    }

    public static EntradaBlogDTO toEntradaBlogDTO(EntradaBlog entradaBlog) {
        return new EntradaBlogDTO(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getNombreDelAutor(), entradaBlog.getFecha());
    }

    public static List<EntradaBlogDTO> toEntradaBlogDTOList(List<EntradaBlog> entradaBlogList) {
        List<EntradaBlogDTO> entradaBlogDTOList = entradaBlogList.stream().map(entradaBlog -> Mapper.toEntradaBlogDTO(entradaBlog)).collect(Collectors.toList());
        return entradaBlogDTOList;
    }
}