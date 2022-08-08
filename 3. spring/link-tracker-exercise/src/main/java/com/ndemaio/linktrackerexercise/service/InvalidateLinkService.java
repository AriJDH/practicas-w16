package com.ndemaio.linktrackerexercise.service;

import com.ndemaio.linktrackerexercise.exception.LinkNotFoundException;
import com.ndemaio.linktrackerexercise.model.Link;
import com.ndemaio.linktrackerexercise.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InvalidateLinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public InvalidateLinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public void invalidateLinkById(UUID id) throws LinkNotFoundException {
        Link link = linkRepository.getLinkById(id).orElseThrow(() -> new LinkNotFoundException("No existe un link con id " + id));
        link.invalidate();
        linkRepository.update(link);
    }

}
