package com.bootcamp.entradasblog.service;

import com.bootcamp.entradasblog.dto.BlogDto;
import com.bootcamp.entradasblog.dto.ResponseDto;

import java.util.List;

public interface IBlogService {

    public ResponseDto addBlog(BlogDto blog);
    public BlogDto getBlog(int id);
    public List<BlogDto> getAllBlogs();
}
