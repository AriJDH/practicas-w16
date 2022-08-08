package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;

import java.util.List;

public interface IBlogRepository {
    boolean createEntry(BlogEntry be);

    BlogEntry getEntry(String id);

    List<BlogEntry> getEntries();
}
