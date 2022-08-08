package com.blog.blog.service;

import com.blog.blog.dto.EntradaBlogDto;
import com.blog.blog.model.EntradaBlog;
import com.blog.blog.repository.EntradaBlogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EntradaBlogService {
    private EntradaBlogRepository blogRepository;

    public EntradaBlogService(EntradaBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Integer createBlog(EntradaBlog entradaBlog){
        Integer blogListId = blogRepository.createBlog(entradaBlog);
        return blogListId;
    }

    public EntradaBlogDto getBlogById(Integer id){
        EntradaBlog blogFound = blogRepository.getBlogById(id);
        EntradaBlogDto blogFoundDto = new EntradaBlogDto();

        blogFoundDto.setIdBlog(blogFound.getIdBlog());
        blogFoundDto.setTitleBlog(blogFound.getTitleBlog());
        blogFoundDto.setNameAuthor(blogFound.getNameAuthor());
        blogFoundDto.setPublicationDate(blogFound.getPublicationDate());

        return blogFoundDto;
    }

    public List<EntradaBlogDto> getAllBlogs(){
        List<EntradaBlog> blogsFound = blogRepository.getAllBlogs();
        List<EntradaBlogDto> blogsDto = new ArrayList<>();

        for (EntradaBlog blog : blogsFound) {
            System.out.println("Blog "+blog);
            blogsDto.add(new EntradaBlogDto(blog.getIdBlog(), blog.getTitleBlog(), blog.getNameAuthor(), blog.getPublicationDate()));
        }

        return blogsDto;
    }
}
