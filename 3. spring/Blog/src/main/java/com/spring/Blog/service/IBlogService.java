package com.spring.Blog.service;

import com.spring.Blog.dto.BlogDTO;
import com.spring.Blog.dto.ResponseDTO;

import java.util.List;

public interface IBlogService {
    ResponseDTO addBlog(BlogDTO blogDTO);
    BlogDTO getBlog(int id);
    List<BlogDTO> getAllBlogs();

}
