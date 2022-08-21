package com.example.springlinktracker.service;

import com.example.springlinktracker.dto.RequestPostLinkDTO;
import com.example.springlinktracker.dto.ResponsePostLinkDTO;
import com.example.springlinktracker.entity.Link;
import com.example.springlinktracker.exception.InvalidLinkException;
import com.example.springlinktracker.exception.LinkNotAuthorizedException;
import com.example.springlinktracker.exception.LinkNotFoundException;
import com.example.springlinktracker.repository.ILinkTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;

@Service
public class LinkTrackerService implements ILinkTrackerService {
    @Autowired
    private ILinkTrackerRepository repository;

    @Override
    public ResponsePostLinkDTO addLink(RequestPostLinkDTO requestPostLinkDTO) {
        if (!validLink(requestPostLinkDTO.getLink())) {
            throw new InvalidLinkException("Invalid link");
        }

        Link newLink = (new ObjectMapper()).convertValue(requestPostLinkDTO, Link.class);
        newLink.setValid(true);
        Integer idLink = this.repository.add(newLink);

        return new ResponsePostLinkDTO(idLink);
    }

    @Override
    public String getLink(Integer ID, String password) {
        Link linkFound = this.repository.getById(ID);

        if (linkFound == null) {
            throw new LinkNotFoundException("Link not found.");
        } else if (!linkFound.isValid()) {
            throw new InvalidLinkException("Invalid link.");
        } else if (!linkFound.getPassword().equals(password)) {
            throw new LinkNotAuthorizedException("Link not authorized.");
        }

        linkFound.setRedirections(linkFound.getRedirections() + 1);
        this.repository.update(linkFound);

        return linkFound.getLink();
    }

    @Override
    public Integer getLinkRedirectionsCount(Integer ID) {
        Link linkReturned = this.repository.getById(ID);
        Integer redirections = 0;

        if (linkReturned == null)
            throw new LinkNotFoundException("Link not found.");

        redirections = linkReturned.getRedirections();

        return redirections;
    }

    @Override
    public void invalidateLink(Integer ID) {
        Link linkToInvalidate = this.repository.getById(ID);

        if (linkToInvalidate == null)
            throw new LinkNotFoundException("Link not found.");

        linkToInvalidate.setValid(false);
        this.repository.update(linkToInvalidate);
    }

    private boolean validLink(String link) {
        try {
            new URL(link).toURI();
            return true;
        } catch (Exception e) {
            throw new InvalidLinkException("Invalid link.");
        }
    }
}
