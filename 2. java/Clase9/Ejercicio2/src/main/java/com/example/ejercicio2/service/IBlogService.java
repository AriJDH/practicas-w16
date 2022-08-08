package com.example.ejercicio2.service;

import com.example.ejercicio2.dto.EntradaBlogDTO;
import com.example.ejercicio2.model.EntradaBlog;

import java.util.List;

public interface IBlogService {
    Integer cargaData(EntradaBlog body);

    List<EntradaBlogDTO> muestraData();

    EntradaBlogDTO getData(Integer id);

}
