package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogEntryDTO;
import com.bootcamp.blog.exception.BlogEntryBadRequestException;
import com.bootcamp.blog.exception.BlogEntryNotFoundException;
import com.bootcamp.blog.model.BlogEntry;
import com.bootcamp.blog.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository repository;

    private final ModelMapper mapper = new ModelMapper();

    @Autowired
    public BlogService(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlogEntryDTO createEntry(BlogEntryDTO be) {
        if(repository.createEntry(mapper.map(be, BlogEntry.class)))
            return be;
        throw new BlogEntryBadRequestException(be.getId());
    }

    @Override
    public BlogEntryDTO getEntry(String id) {
        BlogEntry be = repository.getEntry(id);
        if(be == null)
            throw new BlogEntryNotFoundException(id);
        return mapper.map(be, BlogEntryDTO.class);
    }

    @Override
    public List<BlogEntryDTO> getEntries() {
        return repository.getEntries().stream()
                .map(be -> mapper.map(be, BlogEntryDTO.class))
                .collect(Collectors.toList());
    }
}
