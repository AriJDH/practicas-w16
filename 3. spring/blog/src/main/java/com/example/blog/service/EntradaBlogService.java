package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exceptions.IdDuplicatedException;
import com.example.blog.exceptions.NotFoundElementById;
import com.example.blog.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IEntradaBlogService<EntradaBlogDto>{

    @Autowired
    EntradaBlogRepository entradaBlogRepository;

    @Override
    public List<EntradaBlogDto> getAllBlogs() {
        return entradaBlogRepository.getAllBlogs().stream().
                map(entradaBlog -> new EntradaBlogDto(entradaBlog.getId(),entradaBlog.getTitulo()
                        ,entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion())).collect(Collectors.toList());
    }


    @Override
    public String createPost(EntradaBlogDto entradaBlogDto){
        EntradaBlog entradaBlog = new EntradaBlog(entradaBlogDto.getId(),entradaBlogDto.getTitulo(),
                            entradaBlogDto.getNombre(),entradaBlogDto.getFechaPublicacion());
        if(entradaBlogRepository.findById(entradaBlogDto.getId())==null){
            entradaBlogRepository.createBlog(entradaBlog);
        }else{
            throw new IdDuplicatedException("El post con ese id ya existe");
        }


        return "El post fue creado con el id " +entradaBlog.getId();

    }

    @Override
    public EntradaBlogDto findById(Long id) {

        EntradaBlog entradaBlog = entradaBlogRepository.findById(id);
        if(entradaBlog == null){
          throw new NotFoundElementById("El blog con el id "+ id + " no existe");
        }

        EntradaBlogDto entradaBlogDto = new EntradaBlogDto(entradaBlog.getId(), entradaBlog.getTitulo(),
                entradaBlog.getNombreAutor(), entradaBlog.getFechaPublicacion());

        return entradaBlogDto;
    }
}
