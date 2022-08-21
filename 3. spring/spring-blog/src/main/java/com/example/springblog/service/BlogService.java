package com.example.springblog.service;

import com.example.springblog.dto.EntradaBlogDTO;
import com.example.springblog.dto.IdBlogDTO;
import com.example.springblog.exception.BlogEntryNotFoundException;
import com.example.springblog.exception.IdBlogEntryAlreadyExistsException;
import com.example.springblog.model.EntradaBlog;
import com.example.springblog.repository.IBlogRepository;
import com.example.springblog.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public IdBlogDTO cargar(EntradaBlogDTO entradaBlogDTO) {
        if (this.privateGetById(entradaBlogDTO.getId()) != null) {
            throw new IdBlogEntryAlreadyExistsException(entradaBlogDTO.getId());
        }
        this.blogRepository.cargar(Mapper.toEntradaBlog(entradaBlogDTO));

        return new IdBlogDTO(entradaBlogDTO.getId(), "La entrada del Blog ha sido creada correctamente.");
    }

    @Override
    public EntradaBlogDTO getById(Integer id) {
        EntradaBlog entradaBlogEncontrada = this.privateGetById(id);
        if (entradaBlogEncontrada == null) {
            throw new BlogEntryNotFoundException(id);
        }

        return Mapper.toEntradaBlogDTO(entradaBlogEncontrada);
    }

    @Override
    public List<EntradaBlogDTO> getAll() {
        return Mapper.toEntradaBlogDTOList(this.blogRepository.getAll());
    }

    private EntradaBlog privateGetById(Integer idBlog) {
        EntradaBlog entradaBlogEncontrada = blogRepository.getAll().stream()
                .filter(entradaBlog -> entradaBlog.getId() == idBlog)
                .findFirst()
                .orElse(null);

        return entradaBlogEncontrada;
    }
}
