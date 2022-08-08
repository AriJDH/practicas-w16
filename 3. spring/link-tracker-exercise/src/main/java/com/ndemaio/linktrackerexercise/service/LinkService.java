package com.ndemaio.linktrackerexercise.service;

import com.ndemaio.linktrackerexercise.dto.LinkDTORequest;
import com.ndemaio.linktrackerexercise.dto.LinkDTOResponse;
import com.ndemaio.linktrackerexercise.exception.LinkNotFoundException;
import com.ndemaio.linktrackerexercise.exception.LinkUnauthorizedException;
import com.ndemaio.linktrackerexercise.model.Link;
import com.ndemaio.linktrackerexercise.repository.LinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.util.UUID;

@Service
public class LinkService {

    private final LinkRepository linkRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
        this.modelMapper = new ModelMapper();
    }

    public LinkDTOResponse createLinkBasedOn(LinkDTORequest aLinkRequest) throws MalformedURLException {
        Link link = new Link(aLinkRequest.getUrl(), aLinkRequest.getPassword());
        linkRepository.save(link);
        return modelMapper.map(link, LinkDTOResponse.class);
    }

    public LinkDTOResponse getLinkById(UUID anId) throws LinkNotFoundException {
        Link link = linkRepository.getLinkById(anId).orElseThrow(() -> new LinkNotFoundException("No existe un link con id " + anId));
        return modelMapper.map(link, LinkDTOResponse.class);
    }

    public LinkDTOResponse getLinkByIdIfMatchesPassword(UUID anId, String password) throws LinkNotFoundException, LinkUnauthorizedException {
        Link link = linkRepository.getLinkById(anId).orElseThrow(() -> new LinkNotFoundException("No existe un link con id " + anId));
        if (!link.getPassword().equals(password)) throw new LinkUnauthorizedException("No ingreso la contraseña vàlida.");
        return modelMapper.map(link, LinkDTOResponse.class);
    }

    public void processRedirectTo(LinkDTOResponse aLinkDTO) throws LinkNotFoundException {
        UUID anId = aLinkDTO.getId();
        Link link = linkRepository.getLinkById(anId).orElseThrow(() -> new LinkNotFoundException("No existe un link con id " + anId));
        link.incrementTimesRedirected();
        linkRepository.update(link);
    }
}
