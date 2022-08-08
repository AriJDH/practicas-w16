package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.entity.BlogEntry;

import java.util.List;
import java.util.Optional;

public interface IEntryBlogRepository {

    Boolean createBlog(BlogEntry blogEntry);
    Optional<BlogEntry> getBlogById(String id);
    List<BlogEntry> getAllBlogs();

}
