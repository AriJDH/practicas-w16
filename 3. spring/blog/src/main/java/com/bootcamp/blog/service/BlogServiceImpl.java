package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.exception.BlogAlreadyExistsException;
import com.bootcamp.blog.exception.BlogNotFoundException;
import com.bootcamp.blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<EntradaBlogDTO> listarBlogs() {
        List<EntradaBlogDTO> entradaBlogDTOS = new ArrayList<>();
        List<EntradaBlog> listaEntradaBlog = blogRepository.listarBlogs();

        if (listaEntradaBlog.isEmpty()){
            throw new BlogNotFoundException("No hay blogs para listar.");
        }

        ModelMapper modelMapper = new ModelMapper();
        for (EntradaBlog blog : listaEntradaBlog){
            EntradaBlogDTO blogDTO = modelMapper.map(blog, EntradaBlogDTO.class);
            entradaBlogDTOS.add(blogDTO);
        }

        return entradaBlogDTOS;
    }

    @Override
    public EntradaBlogDTO agregar(EntradaBlogDTO blogDTO) {
        ModelMapper mapper = new ModelMapper();
        EntradaBlog blog = blogRepository.agregar(mapper.map(blogDTO, EntradaBlog.class));
        if (blog == null){
            throw new BlogAlreadyExistsException("Ya existe un Blog con ID: " + blogDTO.getId());
        }
        EntradaBlogDTO blogAgregado = mapper.map(blog, EntradaBlogDTO.class);
        return blogAgregado;
    }

    @Override
    public EntradaBlogDTO buscarBlog(int id) {
        ModelMapper modelMapper = new ModelMapper();
        EntradaBlog blog = blogRepository.buscarBlog(id);
        if (blog == null){
            throw new BlogNotFoundException("No se encontró ningun blog con ID: " + id);
        }

        EntradaBlogDTO entradaBlog = modelMapper.map(blog, EntradaBlogDTO.class);

        return entradaBlog;
    }
}
