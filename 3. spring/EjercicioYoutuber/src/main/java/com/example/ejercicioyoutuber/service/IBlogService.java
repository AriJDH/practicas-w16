package com.example.ejercicioyoutuber.service;

import com.example.ejercicioyoutuber.dto.BlogEntryDto;

import java.util.List;

public interface IBlogService {

    int insertBlog(BlogEntryDto blogEntryDto);

    BlogEntryDto getBlogById(int id);

    List<BlogEntryDto> getAllBlogs();
}
