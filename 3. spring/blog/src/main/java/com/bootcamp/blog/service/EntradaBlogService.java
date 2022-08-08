package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.request.EntradaBlogReqDTO;
import com.bootcamp.blog.dto.response.EntradaBlogCreatedResDTO;
import com.bootcamp.blog.dto.response.EntradaBlogResDTO;
import com.bootcamp.blog.entity.EntradaBlog;
import com.bootcamp.blog.exceptions.ConstraintViolationException;
import com.bootcamp.blog.exceptions.FoundException;
import com.bootcamp.blog.exceptions.NotFoundException;
import com.bootcamp.blog.repository.EntradaBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements IService<EntradaBlogResDTO, Long> {
    private final EntradaBlogRepository entradaBlogRepository;
    private final ModelMapper modelMapper;

    public EntradaBlogService(EntradaBlogRepository entradaBlogRepository, ModelMapper modelMapper) {
        this.entradaBlogRepository = entradaBlogRepository;
        this.modelMapper = modelMapper;
    }

    public List<EntradaBlogResDTO> findAll() {
        return this.entradaBlogRepository.findAll().stream()
                .map(this::parseToEntradaBlogResDTO)
                .collect(Collectors.toList());
    }

    public EntradaBlogResDTO findById(Long id) {
        Optional<EntradaBlog> entradaBlog = this.entradaBlogRepository.findById(id);

        if (entradaBlog.isEmpty()) throw new NotFoundException(
                String.format("No se ha encontrado un blog con el id: %s.", id)
        );

        return this.parseToEntradaBlogResDTO(entradaBlog.get());
    }

    public EntradaBlogCreatedResDTO save(EntradaBlogReqDTO entradaBlogReqDTO) {
        if (this.entradaBlogRepository.findById(entradaBlogReqDTO.getId()).isPresent())
            throw new FoundException("Ya existe un blog con esa id!");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<EntradaBlogReqDTO>> violations = validator.validate(entradaBlogReqDTO);

        if (!violations.isEmpty()) throw new ConstraintViolationException(violations.stream()
                .map(validation -> String.format("%s: %s", validation.getPropertyPath(), validation.getMessage()))
                .collect(Collectors.joining(", ", "[", "]"))
        );

        return this.parseToEntradaBlogCreatedResDTO(
                this.entradaBlogRepository.save(this.parseToEntradaBlog(entradaBlogReqDTO))
        );
    }

    private EntradaBlogResDTO parseToEntradaBlogResDTO(EntradaBlog entradaBlog) {
        return this.modelMapper.map(entradaBlog, EntradaBlogResDTO.class);
    }

    private EntradaBlogCreatedResDTO parseToEntradaBlogCreatedResDTO(EntradaBlog entradaBlog) {
        return this.modelMapper.map(entradaBlog, EntradaBlogCreatedResDTO.class);
    }

    private EntradaBlog parseToEntradaBlog(EntradaBlogReqDTO entradaBlogReqDTO) {
        return this.modelMapper.map(entradaBlogReqDTO, EntradaBlog.class);
    }

}
