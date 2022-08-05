package com.blog.api.repositories;

import com.blog.api.dto.BlogDTO;
import com.blog.api.entity.EntradaBlog;
import com.blog.api.exceptions.BlogExisteException;
import com.blog.api.exceptions.BlogNotFoundException;

import java.util.List;

public interface BlogRepository {
    public BlogDTO saveBlog(EntradaBlog entradaBlog) throws BlogExisteException;
    public List<BlogDTO> getBlogs();
}
