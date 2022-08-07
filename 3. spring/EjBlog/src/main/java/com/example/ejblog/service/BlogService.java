package com.example.ejblog.service;

import com.example.ejblog.dto.EntradaBlogDto;
import com.example.ejblog.exception.BlogNotFoundException;
import com.example.ejblog.model.EntradaBlog;
import com.example.ejblog.repositories.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public EntradaBlogDto save(EntradaBlog entrada) {
        return blogRepository.save(entrada);
    }

    @Override
    public List<EntradaBlogDto> getAllBlogs() {
        return blogRepository.getAllBlogs();
    }

    @Override
    public EntradaBlogDto getBlog(int id) throws BlogNotFoundException{
        return blogRepository.getAllBlogs().stream()
                .filter( b-> b.getId()==id).findFirst()
                .orElseThrow(()-> new BlogNotFoundException("No se encontro el blog con id: "+id));
    }

}