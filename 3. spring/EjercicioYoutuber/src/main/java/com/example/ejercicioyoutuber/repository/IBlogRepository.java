package com.example.ejercicioyoutuber.repository;

import com.example.ejercicioyoutuber.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    public EntradaBlog getById(int id);

    public void insertBlog(EntradaBlog entradaBlog);

    public boolean isPresent(int id );

    List<EntradaBlog> getListaEntradas();
}
