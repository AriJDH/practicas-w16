package com.spring.Blog.service;

import com.spring.Blog.dto.BlogDTO;
import com.spring.Blog.dto.ResponseDTO;
import com.spring.Blog.exception.BlogNotFoundException;
import com.spring.Blog.exception.BlogRepeatedException;
import com.spring.Blog.exception.NoBlogsFoundException;
import com.spring.Blog.model.Blog;
import com.spring.Blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService implements IBlogService{

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public ResponseDTO addBlog(BlogDTO blogDTO) {
        if(!blogRepository.existBlog(blogDTO.getIdBlog())){
            Blog blog = new Blog(blogDTO.getIdBlog(),blogDTO.getTitle(), blogDTO.getAuthorName(), blogDTO.getDate());
            blogRepository.addBlog(blog);
            return new ResponseDTO("Entrada de Blog agregada Correctamente");
        }else{
            throw new BlogRepeatedException(blogDTO.getIdBlog());
        }
    }

    @Override
    public BlogDTO getBlog(int id) {
        if(blogRepository.existBlog(id)){
            Blog blog = blogRepository.getBlog(id);
             new BlogDTO(blog.getIdBlog(),blog.getTitle(),blog.getAuthorName(), blog.getDate());
            return new BlogDTO(blog.getIdBlog(),blog.getTitle(),blog.getAuthorName(), blog.getDate());
        }else{
            throw new BlogNotFoundException(id);
        }

    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs =blogRepository.blogs();
        List<BlogDTO> blogDTOS = new ArrayList<>();

        for (Blog blog: blogs) {
            blogDTOS.add(new BlogDTO(blog.getIdBlog(),blog.getTitle(),blog.getAuthorName(), blog.getDate()));
        }

        if(!blogDTOS.isEmpty()){
            return blogDTOS;
        }else{
            throw new NoBlogsFoundException();
        }


    }
}
