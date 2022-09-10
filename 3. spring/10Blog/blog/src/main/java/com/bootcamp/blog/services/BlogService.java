package com.bootcamp.blog.services;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.MensajeDTO;
import com.bootcamp.blog.exception.BusquedaBlogNotFound;
import com.bootcamp.blog.exception.ListaVacia;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repositories.IBlogRepositorio;
import com.bootcamp.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService{
    @Autowired
    IBlogRepositorio iBlogRepositorio;

    @Override
    public MensajeDTO crearBlog(BlogDTO crearBlogDto) {

      EntradaBlog entradaBlog = Mapper.modelFromBlogDto(crearBlogDto);
      iBlogRepositorio.guardarBlog(entradaBlog);

      return  new MensajeDTO(crearBlogDto.getId(), "Blog creado");
    }

    @Override
    public BlogDTO buscarBlogById(String id) {
        EntradaBlog  entradaBlog = iBlogRepositorio.buscarBlogById(id);
        if (entradaBlog==null) {
            throw new BusquedaBlogNotFound("Blog no encontrado: " + id);
        }
            return Mapper.blogDTOFromModel(entradaBlog);

    }

    @Override
    public List<BlogDTO> buscarListaBlog() {
       List<EntradaBlog> listaBlog = iBlogRepositorio.buscarListaBlog();
       if(listaBlog.isEmpty()) {
           throw new ListaVacia("No hay datos");
       }
       return listaBlog.stream().map(blog -> Mapper.blogDTOFromModel(blog)).collect(Collectors.toList());


    }
}
