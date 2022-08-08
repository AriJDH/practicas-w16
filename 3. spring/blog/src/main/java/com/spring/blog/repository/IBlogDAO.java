package com.spring.blog.repository;

import com.spring.blog.dto.EntradaBlogDTO;
import com.spring.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogDAO {
    Boolean add(EntradaBlogDTO entradaBlogDTO);
    Boolean exists(EntradaBlogDTO entradaBlogDTO);
    EntradaBlog findById(Integer id);
    List<EntradaBlog> findAll();
}
