package com.javaw16.blog.repositories;

import com.javaw16.blog.entities.BlogEntry;

import java.util.ArrayList;
import java.util.List;

public interface IBlogEntriesRepository {

    public void loadEntry(BlogEntry blogEntry);

    public BlogEntry returnEntry(Integer id);

    public List<BlogEntry> returnAsList();
}
