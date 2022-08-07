package com.example.ejblog.repositories;

import com.example.ejblog.dto.EntradaBlogDto;
import com.example.ejblog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    EntradaBlogDto save(EntradaBlog entrada);
    List<EntradaBlogDto> getAllBlogs();

}
