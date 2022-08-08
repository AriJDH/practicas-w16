package com.youtuber.blog.repository;

import com.youtuber.blog.model.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    public String nuevaEntrada(Long id, String nombre, String titulo, String fechaPublicacion);
    public EntradaBlog devolverEntrada(Long id);
    public List<EntradaBlog> allEntradas();
}
