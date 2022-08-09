package com.example.blog.service;

import com.example.blog.dtos.request.NuevaEntradaDTO;
import com.example.blog.dtos.response.EntradaDTO;
import com.example.blog.entities.EntradaBlog;
import com.example.blog.respository.Blogrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Blogservice implements IBlogService {

    @Autowired
    Blogrepository repositorio;


    @Override
    public EntradaDTO buscarEntrada(Integer id) {

        repositorio.repositorioEntradas.stream().filter(x->x.getId().equals(id)).collect(Collectors.toList())


        return null;
    }

    @Override
    public List<EntradaDTO> todasLasEntradas() {
        return null;
    }

    @Override
    public EntradaDTO crearEntrada(NuevaEntradaDTO nuevaEntrada) {

        repositorio.setContador(repositorio.getContador()+1);
        repositorio.repositorioEntradas.add(new EntradaBlog(repositorio.contador, nuevaEntrada.getTitulo(), nuevaEntrada.getNombre(), nuevaEntrada.getFechaDePublicacion()));

        return new EntradaDTO(repositorio.contador, nuevaEntrada.getTitulo(), nuevaEntrada.getNombre(), nuevaEntrada.getFechaDePublicacion());
    }
}
