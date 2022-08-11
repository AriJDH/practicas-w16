package com.bootcamp.linktracer.service;

import com.bootcamp.linktracer.dto.RequestLinkDTO;
import com.bootcamp.linktracer.dto.ResponseActiveDTO;
import com.bootcamp.linktracer.dto.ResponseLinkDTO;
import com.bootcamp.linktracer.dto.ResponseLinkMetricsDTO;
import com.bootcamp.linktracer.exception.IncorrectPasswordException;
import com.bootcamp.linktracer.exception.InvalidUrlException;
import com.bootcamp.linktracer.exception.LinkNotFoundException;
import com.bootcamp.linktracer.model.Link;
import com.bootcamp.linktracer.model.LinkFactory;
import com.bootcamp.linktracer.repository.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    private final ILinkRepository repository;
    private final ModelMapper mapper = new ModelMapper();
    private final LinkFactory factory = new LinkFactory();
    private final UrlValidator validator = new UrlValidator();

    public LinkService(ILinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseLinkDTO createLink(RequestLinkDTO link) {
        if(!validator.isValid(link.getUrl()))
            throw new InvalidUrlException(link.getUrl());
        Link entity = factory.make(link.getUrl(), link.getPassword());
        entity = repository.createLink(entity);
        return new ResponseLinkDTO(entity.getId(), entity.getUrl());
    }

    @Override
    public String redirect(int id, String password) {
        Link link = validateAuthentication(id, password);
        if(!link.isActive())
            throw new LinkNotFoundException(id);
        link.incrementNumRedirects();
        return link.getUrl();
    }

    @Override
    public ResponseLinkMetricsDTO getLinkMetrics(int id, String password) {
        Link link = validateAuthentication(id, password);
        return mapper.map(link, ResponseLinkMetricsDTO.class);
    }

    @Override
    public ResponseActiveDTO disableLink(int id, String password) {
        Link link = validateAuthentication(id, password);
        link.setActive(false);
        return mapper.map(link, ResponseActiveDTO.class);
    }

    @Override
    public ResponseActiveDTO enableLink(int id, String password) {
        Link link = validateAuthentication(id, password);
        link.setActive(true);
        return mapper.map(link, ResponseActiveDTO.class);
    }

    private Link validateAuthentication(int id, String password) {
        Link link = repository.getLink(id);
        if(link == null)
            throw new LinkNotFoundException(id);
        if(link.getPassword() != null && !link.getPassword().equals(password))
            throw new IncorrectPasswordException(id);
        return link;
    }
}
