package com.spring.blog.service;

import com.spring.blog.dto.EntradaBlogDTO;
import com.spring.blog.entity.EntradaBlog;
import com.spring.blog.exception.BlogAlreadyExistsException;
import com.spring.blog.exception.BlogNotFoundException;
import com.spring.blog.exception.NoBlogsFoundException;
import com.spring.blog.repository.IBlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    IBlogDAO iBlogDAO;

    @Override
    public Integer add(EntradaBlogDTO entradaBlogDTO) {
        if(iBlogDAO.exists(entradaBlogDTO)){
            throw new BlogAlreadyExistsException(entradaBlogDTO.getId());
        } else {
            iBlogDAO.add(entradaBlogDTO);
            return entradaBlogDTO.getId();
        }
    }

    @Override
    public EntradaBlogDTO findById(Integer id) {
        EntradaBlog blog = iBlogDAO.findById(id);

        if(blog == null){
            throw new BlogNotFoundException(id);
        } else {
            EntradaBlogDTO response = new EntradaBlogDTO(blog.getId(), blog.getTitle(), blog.getAuthor(), blog.getPublishDate());
            return response;
        }
    }

    @Override
    public List<EntradaBlogDTO> findAll() {
        List<EntradaBlogDTO> blogs = new ArrayList<>();

        if(iBlogDAO.findAll().isEmpty()){
            throw new NoBlogsFoundException();
        }

        for(EntradaBlog blog : iBlogDAO.findAll()){
            blogs.add(new EntradaBlogDTO(blog.getId(), blog.getTitle(), blog.getAuthor(), blog.getPublishDate()));
        }

        return blogs;
    }
}
