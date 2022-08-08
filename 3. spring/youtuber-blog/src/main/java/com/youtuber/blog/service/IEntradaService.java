package com.youtuber.blog.service;

import com.youtuber.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaService {
    public String nuevaEntrada(Long id, String nombre, String titulo, String fechaPublicacion);
    public EntradaBlog devolverEntrada(Long id);
    public List<EntradaBlog> allEntradas();
}
