package com.javaw16.blog.services;

import com.javaw16.blog.dtos.request.ReqBlogEntryDTO;
import com.javaw16.blog.dtos.response.ResBlogEntryDTO;
import com.javaw16.blog.entities.BlogEntry;
import com.javaw16.blog.repositories.IBlogEntriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService implements IBlogEntryService{

    @Autowired
    private IBlogEntriesRepository blogEntriesRepository;
    private ModelMapper mapper;

    public BlogEntryService(IBlogEntriesRepository blogEntriesRepository) {
        this.blogEntriesRepository = blogEntriesRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public void postEntry(ReqBlogEntryDTO reqBlogEntryDTO) {
        BlogEntry blogEntry = new BlogEntry(reqBlogEntryDTO.getId(), reqBlogEntryDTO.getTitle(), reqBlogEntryDTO.getAuthor(), LocalDate.now());
        blogEntriesRepository.loadEntry(blogEntry);
    }

    @Override
    public ResBlogEntryDTO getEntryByID(Integer id) {
        try {
            BlogEntry blogEntry = this.blogEntriesRepository.returnEntry(id);
        } catch ()
        return new ResBlogEntryDTO(blogEntry.getId(),
                blogEntry.getTitle(),
                blogEntry.getAuthor(),
                blogEntry.getPostingDate());
    }

    @Override
    public List<ResBlogEntryDTO> getEntries() {
        return this.blogEntriesRepository.returnAsList().stream()
                .map(blogEntry -> mapper.map(blogEntry, ResBlogEntryDTO.class))
                .collect(Collectors.toList());
    }
}
