package com.mercadolibre.bootcamp.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.bootcamp.dtos.BlogEntryDto;
import com.mercadolibre.bootcamp.exceptions.DuplicatedEntryException;
import com.mercadolibre.bootcamp.exceptions.EntryNotFoundException;
import com.mercadolibre.bootcamp.models.BlogEntry;
import com.mercadolibre.bootcamp.repositories.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private ModelMapper mapper = new ModelMapper();

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        initializeData();
    }

    public void createEntry(BlogEntry newEntry) {
        if (blogRepository.findById(newEntry.getId()) != null)
            throw new DuplicatedEntryException(newEntry.getId());
        blogRepository.createEntry(newEntry);
    }

    public BlogEntryDto searchEntryById(int id) {
        BlogEntry searchResult = blogRepository.findById(id);
        if (searchResult == null)
            throw new EntryNotFoundException(id);
        return mapper.map(searchResult, BlogEntryDto.class);
    }

    public List<BlogEntryDto> getAllEntries() {
        List<BlogEntry> entries = blogRepository.getAllEntries();
        return entries
                .stream()
                .map(e -> mapper.map(e, BlogEntryDto.class))
                .collect(Collectors.toList());
    }

    private void initializeData() {
        blogRepository.createEntry(new BlogEntry(2, "Gato", "Javi", LocalDate.of(2020, 12, 12)));
        blogRepository.createEntry(new BlogEntry(1, "Perrito", "Ricardo", LocalDate.of(2022, 1, 14)));
    }

}
