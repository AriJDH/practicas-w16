package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogEntryDTO;

import java.util.List;

public interface IBlogService {
    BlogEntryDTO createEntry(BlogEntryDTO be);

    BlogEntryDTO getEntry(String id);

    List<BlogEntryDTO> getEntries();
}
