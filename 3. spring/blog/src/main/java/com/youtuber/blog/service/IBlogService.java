package com.youtuber.blog.service;

import com.youtuber.blog.dto.BlogDto;
import com.youtuber.blog.dto.ResponseApiDto;

import java.util.List;

public interface IBlogService {

    ResponseApiDto createBlog(BlogDto blogDto);

    BlogDto getBlogById(Integer id);

    List<BlogDto> listBlog();
}
