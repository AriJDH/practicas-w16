package com.example.elastic.service;

import com.example.elastic.dto.ListaObraDTO;
import com.example.elastic.dto.MensajeDTO;
import com.example.elastic.dto.ObraDTO;
import com.example.elastic.mapper.Mapper;
import com.example.elastic.repository.IObrasLiterarias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObrasLiterariasService  implements IObrasLiterariasService{

    @Autowired
    IObrasLiterarias repo;

    @Autowired
    Mapper mapper;

    @Override
    public ListaObraDTO findByAutor(String autor) {

        ListaObraDTO listaObraDTO = new ListaObraDTO();
        listaObraDTO.setObras(mapper.ObraEntityToObraDto(repo.findByAutor(autor)));
        return listaObraDTO;
    }

    @Override
    public ListaObraDTO findByNombreContainsIgnoreCase(String nombre) {

        ListaObraDTO listaObraDTO = new ListaObraDTO();
        listaObraDTO.setObras(mapper.ObraEntityToObraDto(repo.findByNombreContainsIgnoreCase(nombre)));
        return listaObraDTO;
    }

    @Override
    public ListaObraDTO findByPaginasGreaterThan(Integer paginas) {

        ListaObraDTO listaObraDTO = new ListaObraDTO();
        listaObraDTO.setObras(mapper.ObraEntityToObraDto(repo.findByPaginasGreaterThan(paginas)));
        return listaObraDTO;
    }

    @Override
    public ListaObraDTO findByAnioPublicacionAfter(Integer anio) {

        ListaObraDTO listaObraDTO = new ListaObraDTO();
        listaObraDTO.setObras(mapper.ObraEntityToObraDto(repo.findByAnioPublicacionAfter(anio)));
        return listaObraDTO;
    }

    @Override
    public ListaObraDTO findByAnioPublicacionBefore(Integer anio) {

        ListaObraDTO listaObraDTO = new ListaObraDTO();
        listaObraDTO.setObras(mapper.ObraEntityToObraDto(repo.findByAnioPublicacionBefore(anio)));
        return listaObraDTO;
    }

    @Override
    public ListaObraDTO findByEditorial(String editorial) {

        ListaObraDTO listaObraDTO = new ListaObraDTO();
        listaObraDTO.setObras(mapper.ObraEntityToObraDto(repo.findByEditorial(editorial)));
        return listaObraDTO;

    }

    @Override
    public MensajeDTO save(List<ObraDTO> obras) {

        repo.saveAll(mapper.obraDtoToObraEntity(obras));
        return new MensajeDTO(201, "Obras litearias registradas correctamente");

    }




}
