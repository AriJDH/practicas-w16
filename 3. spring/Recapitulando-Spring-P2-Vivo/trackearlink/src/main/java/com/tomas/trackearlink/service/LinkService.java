package com.tomas.trackearlink.service;

import com.tomas.trackearlink.Entity.Link;
import com.tomas.trackearlink.dto.ExceptionDTO;
import com.tomas.trackearlink.dto.FullLinkDTO;
import com.tomas.trackearlink.dto.LinkDTO;
import com.tomas.trackearlink.dto.LinkIdDTO;
import com.tomas.trackearlink.exception.InvalidUrlException;
import com.tomas.trackearlink.exception.LinkInactiveException;
import com.tomas.trackearlink.exception.LinkNotFoundException;
import com.tomas.trackearlink.exception.PasswordException;
import com.tomas.trackearlink.repository.ILinkRepository;
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
    public LinkIdDTO saveLink(LinkDTO newLink){
        Link linkMapped = mapper.map(newLink,Link.class);
        if(!validator.isValid(linkMapped.getUrl())) {
            throw new InvalidUrlException(newLink.getUrl());
        }
        int id = linkRepo.addLink(linkMapped);

        return new LinkIdDTO(id);
    }

    @Override
    public String redirect(int id, String password){
        Link link = getLinkValidated(id);
        if(!link.getPassword().equals(password)){
            throw new PasswordException(String.valueOf(id));
        }
        if(!link.isActive()) {
            throw new LinkInactiveException(String.valueOf(id));
        }
        link.incrementRedirectCounter();
        linkRepo.updateLink(link);
        return link.getUrl();
    }

    @Override
    public FullLinkDTO getMetrics(int id){
        Link link = getLinkValidated(id);
        return mapper.map(link,FullLinkDTO.class);
    }

    private Link getLinkValidated(int id){
        Link link = linkRepo.getLinkById(id);
        if(link == null) {
            throw new LinkNotFoundException(String.valueOf(id));
        }
        return link;
    }

    @Override
    public ExceptionDTO setInvalidate(int id){
        Link link = getLinkValidated(id);
        linkRepo.updateIsActive(link);
        ExceptionDTO exceptionDto = new ExceptionDTO("The url with " + id + " has been inactive");
        return exceptionDto;
    }



}
