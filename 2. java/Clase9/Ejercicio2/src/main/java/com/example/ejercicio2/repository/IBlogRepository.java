package com.example.ejercicio2.repository;

import com.example.ejercicio2.dto.EntradaBlogDTO;
import com.example.ejercicio2.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    Integer cagarDatos(EntradaBlog body);
    List<EntradaBlog> muestraData();
}
