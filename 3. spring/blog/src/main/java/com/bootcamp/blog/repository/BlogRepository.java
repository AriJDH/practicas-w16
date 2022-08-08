package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    private final List<BlogEntry> blogEntries = new ArrayList<>();

    @Override
    public boolean createEntry(BlogEntry be) {
        if(getEntry(be.getId()) != null)
            return false;
        blogEntries.add(be);
        return true;
    }

    @Override
    public BlogEntry getEntry(String id) {
        return blogEntries.stream()
                .filter(be -> be.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BlogEntry> getEntries() {
        return blogEntries;
    }
}
