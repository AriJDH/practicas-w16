package com.bootcamp.entradasblog.repository;

import com.bootcamp.entradasblog.model.Blog;

import java.util.List;

public interface IBlogRepository {

    public void addBlog(Blog b);
    public Blog getBlog(int id);
    public boolean existsBlog(int id);
    public List<Blog> getBlogs();
}
