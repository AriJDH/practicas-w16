package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogEntryDTO;
import com.bootcamp.blog.dto.BlogEntryIdDTO;
import com.bootcamp.blog.exception.BlogHasNotEntriesException;
import com.bootcamp.blog.exception.BlogIdExistException;
import com.bootcamp.blog.exception.BlogIdNotExistException;
import com.bootcamp.blog.model.BlogEntry;
import com.bootcamp.blog.repository.IBlogEntryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogEntryService implements IBlogEntryService {
    @Autowired
    IBlogEntryRepo blogEntryRepo;
    ModelMapper mapper;
    public BlogEntryService(){
        this.mapper = new ModelMapper();
    }
    @Override
    public BlogEntryIdDTO createBlogEntry(BlogEntryDTO blogEntryDTO) {
        if(blogEntryRepo.isExistBlogEntry(blogEntryDTO.getBlogId())){
            throw new BlogIdExistException(String.valueOf(blogEntryDTO.getBlogId()));
        }
        BlogEntry blogMapped = mapper.map(blogEntryDTO,BlogEntry.class);
        int blogId = blogEntryRepo.addEntry(blogMapped);
        return new BlogEntryIdDTO(blogId);
    }

    @Override
    public BlogEntryDTO getBlogEntry(int id) {
        if(!blogEntryRepo.isExistBlogEntry(id)){
            throw new BlogIdNotExistException(String.valueOf(id));
        }
        BlogEntry blogEntry = blogEntryRepo.getBlogEntry(id);
        BlogEntryDTO blogEntryDTO = mapper.map(blogEntry, BlogEntryDTO.class);
        return blogEntryDTO;
    }

    @Override
    public List<BlogEntryDTO> getBlogsEntries() {
        if(blogEntryRepo.isExistEntries()){
            throw new BlogHasNotEntriesException();
        }
        List<BlogEntryDTO> listEntriesDTO = blogEntryRepo.getBlogsEntries()
                .stream()
                .map(blogEntry-> mapper.map(blogEntry, BlogEntryDTO.class))
                .collect(Collectors.toList());
        return listEntriesDTO;
    }
}
