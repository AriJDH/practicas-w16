package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.dto.BlogEntryDto;
import com.bootcamp.youtuber.dto.ResponseApiDto;
import com.bootcamp.youtuber.entity.BlogEntry;
import com.bootcamp.youtuber.exception.BlogNotFoundException;
import com.bootcamp.youtuber.exception.DuplicatedBlogException;
import com.bootcamp.youtuber.repository.IEntryBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntryBlogService implements IEntryBlogService {

    private final IEntryBlogRepository iEntryBlogRepository;
    private final ModelMapper mapper ;

    public EntryBlogService(IEntryBlogRepository iEntryBlogRepository) {
        this.iEntryBlogRepository = iEntryBlogRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ResponseApiDto createBlog(BlogEntryDto blogEntryDto) {


        if (iEntryBlogRepository.getBlogById(blogEntryDto.getBlogId()).isPresent()){
            throw new DuplicatedBlogException(blogEntryDto.getBlogId());
        }else {
            iEntryBlogRepository.createBlog(mapper.map(blogEntryDto, BlogEntry.class));
        }
        return new ResponseApiDto("Blog Creado", "Blog con id: " + blogEntryDto.getBlogId() + " creado exitosamente");
    }

    @Override
    public Optional<BlogEntryDto> getBlogById(String id) {

        Optional<BlogEntry> blogEntry = iEntryBlogRepository.getBlogById(id);
        if (blogEntry.isEmpty()){
            throw new BlogNotFoundException(id);
        }
        return Optional.of(mapper.map(blogEntry.get(), BlogEntryDto.class));
    }

    @Override
    public List<BlogEntryDto> getAllBlogs() {
        return iEntryBlogRepository.getAllBlogs().stream()
                .map(blogEntry -> mapper.map(blogEntry, BlogEntryDto.class))
                .collect(Collectors.toList());
    }
}
