package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;

import java.util.List;

public interface BlogRepository {
    List<EntradaBlog> listarBlogs();

    EntradaBlog agregar(EntradaBlog blog);

    EntradaBlog buscarBlog(int id);
}
