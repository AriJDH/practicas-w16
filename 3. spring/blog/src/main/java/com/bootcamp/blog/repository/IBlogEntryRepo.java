package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;

import java.util.List;

public interface IBlogEntryRepo {
    int addEntry(BlogEntry blogEntry);

    boolean isExistBlogEntry(int blogId);

    BlogEntry getBlogEntry(int blogId);

    List<BlogEntry> getBlogsEntries();

    boolean isExistEntries();
}
