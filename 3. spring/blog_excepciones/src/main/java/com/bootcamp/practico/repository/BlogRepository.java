package com.bootcamp.practico.repository;


import com.bootcamp.practico.dto.BlogDto;
import com.bootcamp.practico.entity.EntradaBlog;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@org.springframework.stereotype.Repository
public class BlogRepository implements RepositoryAction {

    List<EntradaBlog> blogs = new ArrayList<>();


    @Override
    public void addBlog(BlogDto body) {

        blogs.add(EntradaBlog.builder().id(body.getId()).blog(body.getBlog()).fecha(body.getFecha()).name(body.getName()).build());
    }

    @Override
    public boolean notValidId(BlogDto body) {
       return blogs.stream().filter(entradaBlog -> entradaBlog.getId() == body.getId()).collect(Collectors.toList()).size() > 0;
    }
}
