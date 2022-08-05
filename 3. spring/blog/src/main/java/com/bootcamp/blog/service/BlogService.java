package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.entity.EntradaBlog;

import java.util.List;

public interface BlogService {
    List<EntradaBlogDTO> listarBlogs();

    EntradaBlogDTO agregar(EntradaBlogDTO blog);

    EntradaBlogDTO buscarBlog(int id);
}
