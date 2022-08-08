package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.RequestBlogDto;
import com.bootcamp.blog.dto.ResponseBlogDto;
import com.bootcamp.blog.dto.ResponseBlogListDto;
import com.bootcamp.blog.dto.ResponseFullBlogDto;
import com.bootcamp.blog.exception.BlogAlreadyExistException;
import com.bootcamp.blog.exception.BlogNotFoundException;
import com.bootcamp.blog.model.BlogEntry;
import com.bootcamp.blog.repository.BlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService implements IBlogService {

    private final ModelMapper mapper;

    public BlogService() {
        this.mapper = new ModelMapper();
    }

    @Autowired
    BlogRepository repo;

    @Override
    public ResponseBlogDto createBlogEntry(RequestBlogDto requestBlogDto) {
        if (repo.getBlogEntries().containsKey(requestBlogDto.getIdBlog())) {
            throw new BlogAlreadyExistException(requestBlogDto.getIdBlog());
        } else {

            repo.getBlogEntries().put(requestBlogDto.getIdBlog(), mapper.map(requestBlogDto, BlogEntry.class));
            return new ResponseBlogDto(requestBlogDto.getIdBlog(), "Creado correctamente");
        }

    }

    @Override
    public ResponseFullBlogDto getBlogById(Integer id) {
        if (repo.getBlogEntries().containsKey(id)) {
            ResponseFullBlogDto responseFullBlogDto = mapper.map(repo.getBlogEntries().get(id), ResponseFullBlogDto.class);
            responseFullBlogDto.setId(id);
            return responseFullBlogDto;
        } else {
            throw new BlogNotFoundException(id);

        }

    }

    @Override
    public ResponseBlogListDto getAllBlogs() {
        List<ResponseFullBlogDto> list = new ArrayList<>();

        repo.getBlogEntries().forEach((key, value) -> {
            list.add(mapper.map(repo.getBlogEntries().get(key), ResponseFullBlogDto.class));
            list.get(list.size()-1).setId(key);
        });

        return new ResponseBlogListDto(list);
    }
}
