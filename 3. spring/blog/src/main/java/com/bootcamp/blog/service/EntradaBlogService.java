package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.request.EntradaBlogReqDTO;
import com.bootcamp.blog.dto.response.EntradaBlogCreatedResDTO;
import com.bootcamp.blog.dto.response.EntradaBlogResDTO;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.exceptions.FoundException;
import com.bootcamp.blog.exceptions.NotFoundException;
import com.bootcamp.blog.repository.EntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService {
    private final EntradaBlogRepository entradaBlogRepository;
    private final ModelMapper modelMapper;

    public EntradaBlogService(EntradaBlogRepository entradaBlogRepository, ModelMapper modelMapper) {
        this.entradaBlogRepository = entradaBlogRepository;
        this.modelMapper = modelMapper;
    }

    public List<EntradaBlogResDTO> findAll() {
        return this.entradaBlogRepository.findAll().stream()
                .map(entradaBlogRepository -> this.modelMapper.map(entradaBlogRepository, EntradaBlogResDTO.class))
                .collect(Collectors.toList());
    }

    public EntradaBlogResDTO findById(Long id) {
        Optional<EntradaBlog> entradaBlog = this.entradaBlogRepository.findById(id);

        if (entradaBlog.isEmpty()) throw new NotFoundException(
                String.format("No se ha encontrado un blog con el id: %s.", id)
        );

        return this.modelMapper.map(
                entradaBlog.get(),
                EntradaBlogResDTO.class
        );
    }

    public EntradaBlogCreatedResDTO save(EntradaBlogReqDTO entradaBlogReqDTO) {
        if (this.entradaBlogRepository.findById(entradaBlogReqDTO.getId()).isPresent())
            throw new FoundException("Ya existe un blog con esa id!");

        return this.modelMapper.map(
                this.entradaBlogRepository.save(
                        this.modelMapper.map(
                                entradaBlogReqDTO,
                                EntradaBlog.class
                        )
                ),
                EntradaBlogCreatedResDTO.class
        );
    }

}
