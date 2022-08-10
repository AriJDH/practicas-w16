package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogEntryDTO;
import com.bootcamp.blog.dto.BlogEntryIdDTO;

import java.util.List;

public interface IBlogEntryService {
    public BlogEntryIdDTO createBlogEntry(BlogEntryDTO blogEntryDTO);

    BlogEntryDTO getBlogEntry(int id);

    List<BlogEntryDTO> getBlogsEntries();
}
