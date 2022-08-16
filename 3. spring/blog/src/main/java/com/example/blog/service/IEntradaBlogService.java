package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService <T>{

    public List<T> getAllBlogs();
    public String createPost(T t);
    public T findById(Long id);
}
