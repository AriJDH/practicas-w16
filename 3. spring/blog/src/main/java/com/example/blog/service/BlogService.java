package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDTO;
import com.example.blog.dto.ResponseDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.DuplicateIdException;
import com.example.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BlogService {

    @Autowired
    private BlogRepository repository;

    public ResponseDTO saveEntradaBlog(EntradaBlogDTO blogDTO) {
        if (getBlogById(blogDTO.getId()) != null) {
            throw new DuplicateIdException(blogDTO.getId());
        } else {
            EntradaBlog blog = new EntradaBlog(blogDTO.getId(), blogDTO.getTitulo(), blogDTO.getNombre(), blogDTO.getFechaDePublicacion());
            repository.saveEntradaBlog(blog);
        }
        return new ResponseDTO("Nueva entrada de blog", "Blog con id: " + blogDTO.getId() + "guardado con exito");
    }

    public EntradaBlogDTO getBlogById(Integer id) {
        EntradaBlog blog = repository.getBlogById(id);
        EntradaBlogDTO blogDTO = blog != null ? new EntradaBlogDTO(blog.getId(), blog.getTitulo(), blog.getNombre(), blog.getFechaDePublicacion()) : null;
        return blogDTO;
    }

    public List<EntradaBlogDTO> getAllBlog() {
        return repository.getEntradasBlog().stream()
                .map(b -> new EntradaBlogDTO(b.getId(), b.getTitulo(), b.getNombre(), b.getFechaDePublicacion()))
                .collect(Collectors.toList());
    }
}
