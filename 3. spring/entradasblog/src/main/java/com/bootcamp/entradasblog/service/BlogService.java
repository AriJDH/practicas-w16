package com.bootcamp.entradasblog.service;

import com.bootcamp.entradasblog.dto.BlogDto;
import com.bootcamp.entradasblog.dto.ResponseDto;
import com.bootcamp.entradasblog.exception.BlogNotFoundException;
import com.bootcamp.entradasblog.exception.BlogRepeatedException;
import com.bootcamp.entradasblog.exception.NoBlogsFoundException;
import com.bootcamp.entradasblog.model.Blog;
import com.bootcamp.entradasblog.repository.IBlogRepository;
import org.springframework.stereotype.Service;
import utils.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{

    IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }

    public ResponseDto addBlog(BlogDto blog){
        if (blogRepository.existsBlog(blog.getId()))
            throw new BlogRepeatedException(blog.getId());
        else{
            blogRepository.addBlog(Mapper.BlogFromDto(blog));
            return new ResponseDto("Entrada de Blog agregada correctamente");
        }
    }

    @Override
    public BlogDto getBlog(int id) {
       if (!blogRepository.existsBlog(id))
           throw new BlogNotFoundException(id);
       else
           return Mapper.DTOFromBlog(blogRepository.getBlog(id));
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<Blog> blogs = blogRepository.getBlogs();

        List<BlogDto> blogDTOS = blogs.stream()
                .map(Mapper::DTOFromBlog)
                .collect(Collectors.toList());

        if (blogDTOS.isEmpty()) {
            throw new NoBlogsFoundException();
        }

        return blogDTOS;
    }
}
