package com.example.ejblog.service;

import com.example.ejblog.dto.EntradaBlogDto;
import com.example.ejblog.exception.BlogNotFoundException;
import com.example.ejblog.model.EntradaBlog;

import java.util.List;

public interface IBlogService {

     EntradaBlogDto save(EntradaBlog entrada);
     List<EntradaBlogDto> getAllBlogs();
     EntradaBlogDto getBlog(int id) throws BlogNotFoundException;

}
