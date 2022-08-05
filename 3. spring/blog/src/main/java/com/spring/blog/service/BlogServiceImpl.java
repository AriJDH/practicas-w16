package com.spring.blog.service;

import com.spring.blog.dto.EntradaBlogDTO;
import com.spring.blog.repository.IBlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService{

    @Autowired
    IBlogDAO iBlogDAO;

    @Override
    public Integer add(EntradaBlogDTO entradaBlogDTO) {
        if(iBlogDAO.exists(entradaBlogDTO)){
            // desp va exception aca
            return -1;
        } else {
            iBlogDAO.add(entradaBlogDTO);
            return entradaBlogDTO.getId();
        }
    }
}
