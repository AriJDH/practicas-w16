package com.spring.blog.repository;

import com.spring.blog.dto.EntradaBlogDTO;
import com.spring.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogDAOImpl implements IBlogDAO{

    private List<EntradaBlog> database;

    public BlogDAOImpl(){
        database = new ArrayList<>();
        EntradaBlog entradaBlog = new EntradaBlog(1, "Título 1", "Autor 1", LocalDate.now());
        EntradaBlog entradaBlog2 = new EntradaBlog(2, "Título 2", "Autor 2", LocalDate.now());

        database.add(entradaBlog);
        database.add(entradaBlog2);
    }

    @Override
    public Boolean add(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog = new EntradaBlog(entradaBlogDTO.getId(), entradaBlogDTO.getTitle(), entradaBlogDTO.getAuthor(), entradaBlogDTO.getPublishDate());
        try {
            database.add(entradaBlog);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean exists(EntradaBlogDTO entradaBlogDTO) {
        List<EntradaBlog> lista = database.stream().filter(b -> b.getId().equals(entradaBlogDTO.getId())).collect(Collectors.toList());

        if(lista.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

}
