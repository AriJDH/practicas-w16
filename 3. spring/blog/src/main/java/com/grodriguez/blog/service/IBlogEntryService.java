package com.grodriguez.blog.service;

import com.grodriguez.blog.dto.BlogEntryDTO;
import com.grodriguez.blog.dto.MessageDTO;

import java.util.List;

public interface IBlogEntryService {

    MessageDTO createBlogEntry(BlogEntryDTO blogEntry);

    BlogEntryDTO getBlogEntry(int id);

    List<BlogEntryDTO> getAll();
}
