package com.grodriguez.linkTracker.service;

import com.grodriguez.linkTracker.DTO.*;
import com.grodriguez.linkTracker.entities.Link;
import com.grodriguez.linkTracker.exception.NotFoundException;
import com.grodriguez.linkTracker.exception.UrlNotValidException;
import com.grodriguez.linkTracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService{

    @Autowired
    private ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTO createLink(RequestLinkDTO link) {

        UrlValidator validator = new UrlValidator();
        if(validator.isValid(link.getUrl())){
            return new LinkDTO(linkRepository.createLink(link.getUrl(), link.getPassword()));
        }
        else{
            throw  new UrlNotValidException("La url ingresada no es valida.");
        }
    }

    @Override
    public String redirectLink(int id, String password) {

        Link link = linkRepository.getLink(id, password);

        if(link == null)
            throw new NotFoundException("No se encontro el link con ID: " + id);

        linkRepository.addRedirection(id);

        return "redirect:" + link.getUrl();
    }

    @Override
    public StatisticsDTO getLinkStatistics(int id) {
        return new StatisticsDTO(linkRepository.getLink(id).getRedireccions());
    }

    @Override
    public MessageDTO invalidateLink(int id) {

        if(linkRepository.invalidateLink(id))
            return new MessageDTO("El link se invalido correctamente.");
        else
            throw new NotFoundException("No se encontro el link con Id: " + id);
    }
}
