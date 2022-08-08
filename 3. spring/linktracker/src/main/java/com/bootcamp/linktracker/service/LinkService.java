package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.request.LinkReqDTO;
import com.bootcamp.linktracker.dto.response.LinkCreatedResDTO;
import com.bootcamp.linktracker.dto.response.LinkMetricsResDTO;
import com.bootcamp.linktracker.dto.response.LinkResDTO;
import com.bootcamp.linktracker.entity.Link;
import com.bootcamp.linktracker.exception.ConstraintViolationException;
import com.bootcamp.linktracker.exception.NotFoundException;
import com.bootcamp.linktracker.exception.UrlNotValidException;
import com.bootcamp.linktracker.repository.IRepository;
import com.bootcamp.linktracker.repository.LinkRepository;
import com.bootcamp.linktracker.util.LinkValidation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LinkService implements IService{
    private final IRepository linkRepository;
    private final ModelMapper modelMapper;

    public LinkService(LinkRepository linkRepository, ModelMapper modelMapper) {
        this.linkRepository = linkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public LinkResDTO findById(Long id) {
        Link link = this.linkRepository.findById(id);
        if(link == null) throw new NotFoundException(String.format("No existe un link con la id: %s.", id));
        return this.parseToLinkResDTO(link);
    }

    public LinkResDTO findByIdAndPassword(Long id, String password){
        Link link = this.linkRepository.findByIdAndPassword(id, password);
        if(link == null) throw new NotFoundException("No se encontró el link solicitado");
        link.setViews(link.getViews() + 1);
        this.linkRepository.update(link.getId(), link);
        return this.parseToLinkResDTO(link);
    }

    @Override
    public List<LinkResDTO> findAll() {
        return this.linkRepository.findAll().stream()
                .map(this::parseToLinkResDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LinkCreatedResDTO save(LinkReqDTO model) {
        if(!LinkValidation.validarUrl(model.getLink())) throw new UrlNotValidException("La url no es válida!");
        if(this.linkRepository.findByUrl(model.getLink()) != null) throw new UrlNotValidException("La url ya existe!");
        Link link = this.parseToLink(model);
        link.setPassword(String.valueOf(java.util.UUID.randomUUID()));
        return this.parseToLinkCreatedResDTO(this.linkRepository.save(link));
    }

    @Override
    public void delete(Long id) {
        if(this.linkRepository.findById(id) == null) throw new NotFoundException(String.format("No existe un link con la id: %s.", id));
        this.linkRepository.delete(id);
    }

    public LinkMetricsResDTO getLinkMetrics(Long id) {
        Link link = this.linkRepository.findById(id);
        if(link == null) throw new NotFoundException(String.format("No existe un link con la id: %s.", id));
        return this.parseToLinkMetricsResDTO(link);
    }

    private LinkResDTO parseToLinkResDTO(Link link){
        return this.modelMapper.map(link, LinkResDTO.class);
    }

    private LinkCreatedResDTO parseToLinkCreatedResDTO(Link link){
        return this.modelMapper.map(link, LinkCreatedResDTO.class);
    }

    private Link parseToLink(LinkReqDTO linkReqDTO){
        return this.modelMapper.map(linkReqDTO, Link.class);
    }

    private LinkMetricsResDTO parseToLinkMetricsResDTO(Link link){
        return this.modelMapper.map(link, LinkMetricsResDTO.class);
    }
}
