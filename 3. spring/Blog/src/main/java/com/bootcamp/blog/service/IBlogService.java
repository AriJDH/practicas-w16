package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.RequestBlogDto;
import com.bootcamp.blog.dto.ResponseBlogDto;
import com.bootcamp.blog.dto.ResponseBlogListDto;
import com.bootcamp.blog.dto.ResponseFullBlogDto;

public interface IBlogService {
    ResponseBlogDto createBlogEntry(RequestBlogDto requestBlogDto);

    ResponseFullBlogDto getBlogById(Integer id);

    ResponseBlogListDto getAllBlogs();
}
