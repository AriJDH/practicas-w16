package com.example.blog.repository;

import java.util.List;

public interface IEntradaBlogRepository<T>{

    public List<T> getAllBlogs();
    public void createBlog(T t);
    public T findById(Long id);

}
