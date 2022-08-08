package com.spring.Blog.repository;

import com.spring.Blog.model.Blog;

import java.time.LocalDate;
import java.util.List;

public interface IBlogRepository {
    void addBlog(Blog blog);
    Blog getBlog(int id);
    List<Blog> blogs();
    boolean existBlog(int id);

}
