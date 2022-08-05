package com.example.ejercicioblogyoutuber.service;

import com.example.ejercicioblogyoutuber.dto.BlogEntryDTO;
import com.example.ejercicioblogyoutuber.entity.BlogEntry;
import com.example.ejercicioblogyoutuber.repository.BlogCreationException;
import com.example.ejercicioblogyoutuber.repository.BlogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService {

    private final BlogEntryRepository blogEntryRepository;

    @Autowired
    public BlogEntryService(BlogEntryRepository blogEntryRepository) {
        this.blogEntryRepository = blogEntryRepository;
    }

    public List<BlogEntryDTO> getBlogs() {
        return blogEntryRepository.getAll().stream().map(blog -> new BlogEntryDTO(blog)).collect(Collectors.toList());
    }

    public BlogEntryDTO getBlogById(Long id) throws BlogNotFoundException {
        BlogEntry blogEntry = blogEntryRepository.getBlogById(id).orElseThrow(() -> new BlogNotFoundException("No existe un blog con ID: " + id));
        return new BlogEntryDTO(blogEntry);
    }

    public void create(BlogEntryDTO blogEntryDTO) throws BlogCreationException {
        BlogEntry blogEntry = new BlogEntry(blogEntryDTO.getId(), blogEntryDTO.getTitle(),blogEntryDTO.getAuthor(), blogEntryDTO.getPublicationDate());
        blogEntryRepository.save(blogEntry);
    }
}
