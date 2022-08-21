package com.example.springblog.service;

import com.example.springblog.dto.EntradaBlogDTO;
import com.example.springblog.dto.IdBlogDTO;

import java.util.List;

public interface IBlogService {
    IdBlogDTO cargar(EntradaBlogDTO body);

    EntradaBlogDTO getById(Integer id);

    List<EntradaBlogDTO> getAll();
}
