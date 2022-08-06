package com.tomas.blog.service;

import com.tomas.blog.dto.BlogCreadoDTO;
import com.tomas.blog.dto.BlogDTO;
import com.tomas.blog.dto.ListaBlogDTO;


public interface IBlogService {

    BlogCreadoDTO crearBlog(BlogDTO entradaBlog);
    BlogDTO  consultarBlog(int id);
    ListaBlogDTO obtenerBlogs();

}
