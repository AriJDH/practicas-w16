package com.example.ejercicioyoutuber.service;

import com.example.ejercicioyoutuber.dto.BlogEntryDto;
import com.example.ejercicioyoutuber.entity.EntradaBlog;
import com.example.ejercicioyoutuber.exception.BlogIdAlreadyExistsException;
import com.example.ejercicioyoutuber.exception.BlogIdNotFoundException;
import com.example.ejercicioyoutuber.repository.BlogRepository;
import com.example.ejercicioyoutuber.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{

    @Autowired
    IBlogRepository blogRepository;

    @Override
    public int insertBlog(BlogEntryDto blogEntryDto) {
        if(blogRepository.isPresent(blogEntryDto.getBlogID())){
            throw new BlogIdAlreadyExistsException();
        }
        EntradaBlog entradaBlog = new EntradaBlog(blogEntryDto.getBlogID(), blogEntryDto.getBlogTitle(), blogEntryDto.getAuthorName(), blogEntryDto.getPublishDate());
        blogRepository.insertBlog(entradaBlog);
        return entradaBlog.getBlogID();
    }

    @Override
    public BlogEntryDto getBlogById(int id) {
        if(!blogRepository.isPresent(id)){
            throw new BlogIdNotFoundException();
        }
        EntradaBlog blog = blogRepository.getById(id);
        BlogEntryDto blogEntryDto = new BlogEntryDto(blog.getBlogID(), blog.getBlogTitle(), blog.getAuthorName(), blog.getPublishDate());

        return blogEntryDto;
    }

    @Override
    public List<BlogEntryDto> getAllBlogs() {
        return blogRepository.getListaEntradas().stream().map(blog->new BlogEntryDto(blog.getBlogID(), blog.getBlogTitle(), blog.getAuthorName(), blog.getPublishDate())).collect(Collectors.toList());
    }
}
