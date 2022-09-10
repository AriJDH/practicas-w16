package com.bootcamp.blog.services;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.MensajeDTO;

import java.util.List;

public interface IBlogService {
    public MensajeDTO crearBlog(BlogDTO crearBlogDto);
    public BlogDTO buscarBlogById(String id);

    public List<BlogDTO> buscarListaBlog();
}
