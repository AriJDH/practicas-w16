package com.spring.blog.service;

import com.spring.blog.dto.EntradaBlogDTO;

import java.util.List;

public interface IBlogService {
    Integer add(EntradaBlogDTO entradaBlogDTO);
    EntradaBlogDTO findById(Integer id);
    List<EntradaBlogDTO> findAll();
}
