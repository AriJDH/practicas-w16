package com.bootcamp.blog.repositories;

import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepositorio {
    public void guardarBlog(EntradaBlog entradaBlog);
    public EntradaBlog buscarBlogById(String id);
    public List<EntradaBlog> buscarListaBlog();
}
