package com.tomas.blog.repository;


import com.tomas.blog.entity.EntradaBlog;

import java.util.HashMap;
import java.util.List;

public interface IBlogRepository {

    Integer guardarEntradaBlog(Integer id, String titulo, String nombreAutor, String fechaPublicacion);
    Boolean consultarExistenciaBlog(Integer id);
    List<String> traerInformacion(int id);
    HashMap<Integer, EntradaBlog> obtenerTodosBlogs();
}
