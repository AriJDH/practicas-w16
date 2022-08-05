package com.blog.api.services;

import com.blog.api.dto.BlogDTO;
import com.blog.api.entity.EntradaBlog;
import com.blog.api.exceptions.BlogExisteException;
import com.blog.api.exceptions.BlogNotFoundException;
import com.blog.api.repositories.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{
    private final BlogRepository blogRepository;

    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public BlogDTO save(EntradaBlog entrada) throws BlogExisteException {
        return blogRepository.saveBlog(entrada);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        return blogRepository.getBlogs();
    }

    @Override
    public BlogDTO getBlog(Long id) throws BlogNotFoundException {

        return blogRepository.getBlogs().stream()
                .filter( b-> b.getId()==id).findFirst()
                .orElseThrow(()-> new BlogNotFoundException("No se encontro el blog con id: "+id));
    }
}
