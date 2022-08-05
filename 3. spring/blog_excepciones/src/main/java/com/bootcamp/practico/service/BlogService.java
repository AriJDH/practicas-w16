package com.bootcamp.practico.service;


import com.bootcamp.practico.dto.BlogDto;
import com.bootcamp.practico.dto.ResponseMessageDto;
import com.bootcamp.practico.exception.BlogBadRequestException;
import com.bootcamp.practico.exception.BlogCreatedException;
import com.bootcamp.practico.exception.BlogIdAlreadyCreated;
import com.bootcamp.practico.exception.IdNotFoundException;
import com.bootcamp.practico.repository.RepositoryAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class BlogService implements BlogAction {

    @Autowired
    private RepositoryAction repository;

    @Override
    public ResponseMessageDto addBlog(BlogDto body) {
        if (!body.validate())
            throw new BlogBadRequestException("Datos vacios o nulos");
        if (repository.notValidId(body))
            throw new BlogIdAlreadyCreated("el id ingresado ya existe");

        repository.addBlog(body);
        return ResponseMessageDto.builder().message("blog added").build();
    }

    @Override
    public BlogDto getBlogById(int id) {

        BlogDto blogDto = repository.getBlogs().stream().filter(entradaBlog -> entradaBlog.getId() == id).map(entradaBlog ->
                BlogDto.builder().id(entradaBlog.getId()).
                        fecha(entradaBlog.getFecha()).blog(entradaBlog.getBlog())
                        .name(entradaBlog.getName()).build()).collect(toList()).stream().findFirst().orElse(null);
        if (blogDto == null)
            throw new IdNotFoundException("id not found");
        return blogDto;
    }
}
