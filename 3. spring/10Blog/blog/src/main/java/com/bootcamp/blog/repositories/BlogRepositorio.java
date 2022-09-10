package com.bootcamp.blog.repositories;

import com.bootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositorio implements IBlogRepositorio{
    List<EntradaBlog> listaBlogs = new ArrayList<>();


    @Override
    public void guardarBlog(EntradaBlog entradaBlog) {
        listaBlogs.add(entradaBlog);//guarda en la BD

    }

    @Override
    public EntradaBlog buscarBlogById(String id) {
      return listaBlogs.stream()
                .filter(blog -> blog.getId().equals(id)).findFirst()
                .orElse(null);//si no hay ese id devuelve null

    }

    @Override
    public List<EntradaBlog> buscarListaBlog() {
        return listaBlogs;
    }
}
