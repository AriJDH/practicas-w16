package com.example.ejblog.repositories;

import com.example.ejblog.dto.EntradaBlogDto;
import com.example.ejblog.exception.BlogExisteException;
import com.example.ejblog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepository implements IBlogRepository {

    private List<EntradaBlogDto> listaBlogs;

    public BlogRepository() {
        this.listaBlogs = new ArrayList<>();
    }

    @Override
    public EntradaBlogDto save(EntradaBlog entrada) {
        EntradaBlogDto blog=new EntradaBlogDto(entrada.getId(),entrada.getTitulo(),entrada.getNombreAutor(),entrada.getFecha());

        if(blog.getId()==0){
            blog.setId(listaBlogs.size()+1);
        }

        List<EntradaBlogDto> blogs = this.listaBlogs.stream().filter(b-> b.getId() == entrada.getId()).collect(Collectors.toList());
        if(blogs.size()>0){
            try {
                throw new BlogExisteException("El blog con id:"+entrada.getId()+" ya existe");
            } catch (BlogExisteException e) {
                throw new RuntimeException(e);
            }
        }

        this.listaBlogs.add(blog);
        return blog;
    }

    @Override
    public List<EntradaBlogDto> getAllBlogs() {
        return this.listaBlogs;
    }

}
