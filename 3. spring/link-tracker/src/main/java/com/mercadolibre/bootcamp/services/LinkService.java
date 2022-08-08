package com.mercadolibre.bootcamp.services;

import com.mercadolibre.bootcamp.dtos.response.FullLinkDto;
import com.mercadolibre.bootcamp.dtos.request.LinkDto;
import com.mercadolibre.bootcamp.dtos.response.LinkIdDto;
import com.mercadolibre.bootcamp.exceptions.DisabledLinkException;
import com.mercadolibre.bootcamp.exceptions.InvalidUrlException;
import com.mercadolibre.bootcamp.exceptions.LinkNotFoundException;
import com.mercadolibre.bootcamp.exceptions.PasswordMissmatchException;
import com.mercadolibre.bootcamp.models.Link;
import com.mercadolibre.bootcamp.repositories.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {
    ILinkRepository linkRepo;
    UrlValidator validator;
    ModelMapper mapper;

    public LinkService(ILinkRepository linkRepo) {
        this.linkRepo = linkRepo;
        this.validator = new UrlValidator();
        this.mapper = new ModelMapper();
    }

    public LinkIdDto saveLink(LinkDto newLink) {
        Link linkMapped = mapper.map(newLink, Link.class);
        if (!validator.isValid(linkMapped.getUrl())) {
            throw new InvalidUrlException(newLink.getUrl());
        }
        int id = linkRepo.addLink(linkMapped);
        return new LinkIdDto(id);
    }

    public String redirect(int id, String password) {
        Link link = getLinkValidated(id);
        if (!link.isActive()) {
            throw new DisabledLinkException(String.valueOf(id));
        }
        if(link.getPassword()!= null &&  !link.getPassword().equals(password)){
            throw new PasswordMissmatchException(String.valueOf(id));
        }
        link.incrementRedirectCounter();
        linkRepo.updateLink(link);
        return link.getUrl();
    }

    public FullLinkDto getMetrics(int id) {
        Link link = getLinkValidated(id);
        return mapper.map(link, FullLinkDto.class);
    }

    public void disableLink(int id) {
        Link link = getLinkValidated(id);
        link.setActive(false);
        linkRepo.updateLink(link);
    }

    private Link getLinkValidated(int id) {
        Link link = linkRepo.getLinkById(id);
        if (link == null) {
            throw new LinkNotFoundException(String.valueOf(id));
        }
        return link;
    }

}
