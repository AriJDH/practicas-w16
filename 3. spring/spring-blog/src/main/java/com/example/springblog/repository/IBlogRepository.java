package com.example.springblog.repository;

import com.example.springblog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    Integer cargar(EntradaBlog entradaBlog);

    List<EntradaBlog> getAll();
}
