package com.ejerciciointegrador.blog.service;

import com.ejerciciointegrador.blog.dto.EntradaBlogDTO;
import com.ejerciciointegrador.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {

    void save(EntradaBlogDTO entradaBlog);
    EntradaBlogDTO find(long id);
    List<EntradaBlogDTO> findAll();
}
