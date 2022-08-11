package com.grodriguez.blog.repository;

import com.grodriguez.blog.entities.BlogEntry;

import java.util.List;

public interface IBlogEntryRepository {

    String createBlogEntry(BlogEntry be);

    BlogEntry getBlogEntry(int id);

    List<BlogEntry> getAll();
}
