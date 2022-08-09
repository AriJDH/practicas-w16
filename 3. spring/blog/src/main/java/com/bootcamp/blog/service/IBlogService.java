package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogPostDTO;
import com.bootcamp.blog.dto.BlogResponseDTO;

import java.util.List;

public interface IBlogService {

    BlogResponseDTO newBlogService (BlogPostDTO blogPostDTO);
    List<BlogPostDTO> allBlogsService();
    BlogPostDTO findBlogService(Integer id);

}
