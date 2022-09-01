package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    Long create(Joya jo);

    Joya findById(Long id);

    List<Joya> getAll();

    Joya update(Joya joya);

    void delete(Long id);
}
