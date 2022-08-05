package com.bootcamp.practico.repository;

import com.bootcamp.practico.dto.BlogDto;
import com.bootcamp.practico.entity.EntradaBlog;

import java.util.List;

public interface RepositoryAction {

    public void addBlog(BlogDto body);

    boolean notValidId(BlogDto body);

    public List<EntradaBlog> getBlogs();
}
