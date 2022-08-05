package com.blog.api.services;

import com.blog.api.dto.BlogDTO;
import com.blog.api.entity.EntradaBlog;
import com.blog.api.exceptions.BlogExisteException;
import com.blog.api.exceptions.BlogNotFoundException;

import java.util.List;

public interface BlogService {

    public BlogDTO save(EntradaBlog entrada) throws BlogExisteException;
    public List<BlogDTO> getAllBlogs();
    public BlogDTO getBlog(Long id) throws BlogNotFoundException;


}
