package com.example.linkTraker.service;


import com.example.linkTraker.dto.LinkDto;
import com.example.linkTraker.dto.LinkIdDto;
import com.example.linkTraker.exception.BadRequestException;
import com.example.linkTraker.repository.LinkRepository;
import com.example.linkTraker.utils.ServiceUtils;
import org.apache.commons.validator.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkService implements ILinkService {

    @Autowired
    LinkRepository repository;

    @Autowired
    ServiceUtils utils;


    @Override
    public LinkIdDto createLink(LinkDto link) {

        UrlValidator validator = new UrlValidator();
        if (!validator.isValid(link.getUrl())){
            throw new BadRequestException("Invalido");

        } else {
            Integer id = repository.getLinks().size()+1;
            return new LinkIdDto(id);
        }
    }


}
