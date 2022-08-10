package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BlogEntryRepo implements IBlogEntryRepo{
    Map<Integer, BlogEntry> entries = new HashMap<>();
    @Override
    public int addEntry(BlogEntry blogEntry) {
        entries.put(blogEntry.getBlogId(),blogEntry);
        return blogEntry.getBlogId();
    }

    @Override
    public boolean isExistBlogEntry(int blogId){
        BlogEntry blogEntry = entries.get(blogId);
        if(blogEntry == null){
            return false;
        }
        return true;
    }
    @Override
    public BlogEntry getBlogEntry(int blogId){
        return entries.get(blogId);
    }
    @Override
    public List<BlogEntry> getBlogsEntries(){
        List<BlogEntry> listEntries = new ArrayList<>();
        entries.entrySet().stream().
                map(blogEntry -> listEntries.add(blogEntry.getValue()))
                .collect(Collectors.toList());

        return listEntries;
    }
    @Override
    public boolean isExistEntries(){
        return entries.isEmpty();
    }
}
