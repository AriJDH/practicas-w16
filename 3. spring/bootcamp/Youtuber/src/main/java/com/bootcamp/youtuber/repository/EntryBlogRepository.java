package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.entity.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntryBlogRepository implements IEntryBlogRepository{

    List<BlogEntry> blogs = new ArrayList<>();

    @Override
    public Boolean createBlog(BlogEntry blogEntry) {
        return blogs.add(blogEntry);
    }

    @Override
    public Optional<BlogEntry> getBlogById(String id) {
        if(!blogs.isEmpty()) {
            return blogs.stream().filter(blogEntry -> blogEntry.getBlogId().equals(id)).findFirst();
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<BlogEntry> getAllBlogs() {
        return blogs;
    }
}
