package com.example.elasticvivo.service;

import com.example.elasticvivo.model.Obra;

import java.util.List;

public interface ObraService {
    Obra createObra(Obra obra);

    List<Obra> getObrasAutor(String nombre);

    List<Obra> getObrasTitulo(String titulo);

    List<Obra> getObrasCantPaginas(Integer paginas);

    List<Obra> getObrasPosterior(Integer anho);

    List<Obra> getObrasAnterior(Integer anho);

    List<Obra> getObrasEditorial(String editorial);
}
