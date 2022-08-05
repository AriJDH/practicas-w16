package com.example.ejercicioblogyoutuber.repository;

import com.example.ejercicioblogyoutuber.entity.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogEntryRepository {

    private final List<BlogEntry> blogEntries;

    public BlogEntryRepository() {
        blogEntries = new ArrayList<>();
    }

    public List<BlogEntry> getAll() {
        return blogEntries;
    }

    public Optional<BlogEntry> getBlogById(Long anId) {
        return blogEntries.stream().filter(blogEntry -> blogEntry.getId().equals(anId)).findFirst();
    }

    public void save(BlogEntry aBlogEntry) throws BlogCreationException {
        validateNotExistsBlogWith(aBlogEntry.getId());
        blogEntries.add(aBlogEntry);
    }

    private void validateNotExistsBlogWith(Long anId) throws BlogCreationException {
        if (blogEntries.stream().anyMatch(blogEntry -> blogEntry.getId().equals(anId))) throw new BlogCreationException("Ya existe un blog creado con ID: " + anId);
    }
}
