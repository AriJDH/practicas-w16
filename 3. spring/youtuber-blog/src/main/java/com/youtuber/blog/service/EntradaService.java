package com.youtuber.blog.service;

import com.youtuber.blog.exceptions.NotFoundException;
import com.youtuber.blog.model.EntradaBlog;
import com.youtuber.blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService implements IEntradaService{
    @Autowired
    EntradaBlogRepository entradaRepo;
    @Override
    public String nuevaEntrada(Long id, String nombre, String titulo, String fechaPublicacion) {
        String entradaCreada = entradaRepo.nuevaEntrada(id, nombre, titulo, fechaPublicacion);
        if(entradaCreada == null){
            throw new NotFoundException("El id " + id + " ya existe.");
        }
        return entradaCreada;
    }

    @Override
    public EntradaBlog devolverEntrada(Long id) {
        EntradaBlog entradaEncontrada = entradaRepo.devolverEntrada(id);
        if(entradaEncontrada == null){
            throw new NotFoundException("El id " + id + " no existe.");
        }
        return entradaEncontrada;
    }

    @Override
    public List<EntradaBlog> allEntradas() {
        return entradaRepo.allEntradas();
    }
}
