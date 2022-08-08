package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.dto.BlogEntryDto;
import com.bootcamp.youtuber.dto.ResponseApiDto;

import java.util.List;
import java.util.Optional;

public interface IEntryBlogService {

    ResponseApiDto createBlog(BlogEntryDto blogEntryDto);
    Optional<BlogEntryDto> getBlogById(String id);
    List<BlogEntryDto> getAllBlogs();

}
