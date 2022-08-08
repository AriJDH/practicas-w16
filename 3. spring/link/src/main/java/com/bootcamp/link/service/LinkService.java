package com.bootcamp.link.service;

import com.bootcamp.link.dto.CreateLinkDto;
import com.bootcamp.link.dto.ResponseCreateLinkDto;
import com.bootcamp.link.dto.ResponseMetricsDto;
import com.bootcamp.link.entity.Link;
import com.bootcamp.link.exception.DisabledLinkException;
import com.bootcamp.link.exception.InvalidLinkException;
import com.bootcamp.link.exception.NotFoundLinkException;
import com.bootcamp.link.exception.UnauthorizedException;
import com.bootcamp.link.repository.ILinkRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService {

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public ResponseCreateLinkDto createLink(CreateLinkDto createLinkDto) {
        Link link = new Link(createLinkDto.getLink(), createLinkDto.getPassword(), 0, true);
        int responseId = linkRepository.createLink(link);

        return new ResponseCreateLinkDto(responseId);
    }

    @Override
    public String isValidUrl(int id, String password) {

        validateId(id);

        Link result = linkRepository.findById(id);

        if (!result.getPassword().equals(password)) {
            throw new UnauthorizedException();
        }

        if (!result.isValid()) {
            throw new DisabledLinkException();
        }

        UrlValidator defaultValidator = new UrlValidator();
        boolean isValid = defaultValidator.isValid(result.getUrl());

        if (!isValid) {
            throw new InvalidLinkException();
        }

        result.incrementRedirect();
        return "redirect:" + result.getUrl();
    }

    @Override
    public ResponseMetricsDto sumRedirectLink(int id) {

        validateId(id);
        Link result = linkRepository.findById(id);

        return new ResponseMetricsDto(result.getRedirects());
    }

    @Override
    public void disabledLink(int id) {
        validateId(id);
        Link result = linkRepository.findById(id);
        result.setValid(false);
    }

    private void validateId(int id) {
        if (!linkRepository.hasId(id)) {
            throw new NotFoundLinkException();
        }
    }
}
