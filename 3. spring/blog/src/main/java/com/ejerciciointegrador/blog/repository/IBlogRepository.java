package com.ejerciciointegrador.blog.repository;

import com.ejerciciointegrador.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    void save(EntradaBlog entradaBlog);
    EntradaBlog find(long id);

    List<EntradaBlog> findAll();
}
