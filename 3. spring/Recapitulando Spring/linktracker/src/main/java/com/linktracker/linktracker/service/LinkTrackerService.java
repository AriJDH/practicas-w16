package com.linktracker.linktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linktracker.linktracker.dto.ResponseLinkDTO;
import com.linktracker.linktracker.dto.RequestLinkDTO;
import com.linktracker.linktracker.entity.Link;
import com.linktracker.linktracker.exceptions.InvalidLinkException;
import com.linktracker.linktracker.exceptions.LinkNotAuthorizatedException;
import com.linktracker.linktracker.exceptions.LinkNotFoundException;
import com.linktracker.linktracker.repository.IRepository;

import java.net.URL;

@Service
public class LinkTrackerService implements IService{
    @Autowired
    private IRepository repository;

    public ResponseLinkDTO addLink(RequestLinkDTO link){
        if(!validateLink(link.getLink())){
            throw new InvalidLinkException("Invalid link");
        }

        ObjectMapper mapper = new ObjectMapper();
        Link newLink = mapper.convertValue(link, Link.class);

        Integer IDReturned = repository.addLink(newLink);

        return new ResponseLinkDTO(IDReturned);
    }

    @Override
    public String getLink(Integer ID){
        String link = null;
        Link linkReturned = repository.getLink(ID);

        if(linkReturned == null){
            throw new LinkNotFoundException("Link not found.");
        }else if(!linkReturned.isValid()){
            throw new InvalidLinkException("Link invalid.", linkReturned.getLink());
        }
        
        link = linkReturned.getLink();
        linkReturned.setRedirections(linkReturned.getRedirections() + 1);
    

        return link;
    }

    @Override
    public String getLinkAuthorizated(Integer ID, String password){
        String link = null;
        Link linkReturned = repository.getLink(ID);

        if(linkReturned == null){
            throw new LinkNotFoundException("Link not found.");
        }else if(!linkReturned.isValid()){
            throw new InvalidLinkException("Link invalid.", linkReturned.getLink());
        }else if(!linkReturned.getPassword().equals(password)){
            throw new LinkNotAuthorizatedException("Link not authorized.");
        }

        link = linkReturned.getLink();
        linkReturned.setRedirections(linkReturned.getRedirections() + 1);

        return link;
    }

    @Override
    public Integer getRedirections(Integer ID){
        Link linkReturned = repository.getLink(ID);
        Integer redirections = 0;

        if(linkReturned == null)
            throw new LinkNotFoundException("Link not found.");

        redirections = linkReturned.getRedirections();

        return redirections;
    }

    @Override
    public boolean invalidateLink(Integer ID){
        boolean invalidated = false;
        Link linkReturned = repository.getLink(ID);

        if(linkReturned == null)
            throw new LinkNotFoundException("Link not found.");

        repository.invalidateLink(ID);
        invalidated = true;

        return invalidated;
    }

    public boolean validateLink(String link){
        try{
            new URL(link).toURI();
            return true;
        }catch(Exception e){
            throw new InvalidLinkException("Invalid link", link);
        }
    }
}
