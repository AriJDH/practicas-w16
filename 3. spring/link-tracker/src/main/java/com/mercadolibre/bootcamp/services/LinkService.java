package com.mercadolibre.bootcamp.services;

import com.mercadolibre.bootcamp.dtos.FullLinkDto;
import com.mercadolibre.bootcamp.dtos.request.LinkDto;
import com.mercadolibre.bootcamp.dtos.response.LinkIdDto;
import com.mercadolibre.bootcamp.exceptions.InvalidUrlException;
import com.mercadolibre.bootcamp.exceptions.LinkNotFoundException;
import com.mercadolibre.bootcamp.models.Link;
import com.mercadolibre.bootcamp.repositories.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    ILinkRepository linkRepo;
    UrlValidator validator;
    ModelMapper mapper;

    public LinkService(ILinkRepository linkRepo) {
        this.linkRepo = linkRepo;
        this.validator = new UrlValidator();
        this.mapper = new ModelMapper();
    }

    @Override
    public LinkIdDto saveLink(LinkDto newLink){
        Link linkMapped = mapper.map(newLink,Link.class);
        if(!validator.isValid(linkMapped.getUrl())) {
            throw new InvalidUrlException(newLink.getUrl());
        }
        int id = linkRepo.addLink(linkMapped);

        return new LinkIdDto(id);
    }

    @Override
    public String redirect(int id){
        Link link = getLinkValidated(id);
        link.incrementRedirectCounter();
        linkRepo.updateLink(link);
        return link.getUrl();
    }

    @Override
    public FullLinkDto getMetrics(int id){
        Link link = getLinkValidated(id);
        return mapper.map(link,FullLinkDto.class);
    }

    private Link getLinkValidated(int id){
        Link link = linkRepo.getLinkById(id);
        if(link == null) {
            throw new LinkNotFoundException(String.valueOf(id));
        }
        return link;
    }

}
