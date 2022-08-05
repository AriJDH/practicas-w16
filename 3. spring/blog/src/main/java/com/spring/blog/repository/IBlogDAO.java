package com.spring.blog.repository;

import com.spring.blog.dto.EntradaBlogDTO;

public interface IBlogDAO {
    Boolean add(EntradaBlogDTO entradaBlogDTO);
    Boolean exists(EntradaBlogDTO entradaBlogDTO);
}
