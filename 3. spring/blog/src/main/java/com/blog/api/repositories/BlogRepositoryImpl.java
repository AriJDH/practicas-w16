package com.blog.api.repositories;

import com.blog.api.dto.BlogDTO;
import com.blog.api.entity.EntradaBlog;
import com.blog.api.exceptions.BlogExisteException;
import com.blog.api.exceptions.BlogNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepositoryImpl implements BlogRepository{

    private List<BlogDTO> blogDTOList;
    public BlogRepositoryImpl() {
        this.blogDTOList = new ArrayList<>();
    }

    @Override
    public BlogDTO saveBlog(EntradaBlog entradaBlog) throws BlogExisteException {
        BlogDTO blog = new BlogDTO();
        if(this.blogDTOList.isEmpty()){
            blog = new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
            this.blogDTOList.add(blog);
            return blog;
        }
        List<BlogDTO> blogDTOS = this.blogDTOList.stream().filter(b-> b.getId() == entradaBlog.getId()).collect(Collectors.toList());
        if(blogDTOS.size()>0){
            throw new BlogExisteException("El blog con id:"+entradaBlog.getId()+" ya existe");
        }else{
          blog = new BlogDTO(entradaBlog.getId(),entradaBlog.getTitulo(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
          this.blogDTOList.add(blog);
        }
        return blog;
    }

    @Override
    public List<BlogDTO> getBlogs() {
        return this.blogDTOList;
    }


}
