package com.youtuber.blog.repository;

import com.youtuber.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Boolean createBlog(Blog blog);
    Optional<Blog> getBlogById(Integer id);
    List<Blog> listBlog();
}
