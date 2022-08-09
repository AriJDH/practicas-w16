package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.CreateLinkDto;
import com.bootcamp.linktracker.dto.ResponseCreateLinkDto;
import com.bootcamp.linktracker.dto.ResponseMetricDto;
import com.bootcamp.linktracker.entity.Link;
import com.bootcamp.linktracker.repository.ILinkRepository;
import com.bootcamp.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository) {this.linkRepository = linkRepository;}


    @Override
    public ResponseCreateLinkDto createLink(CreateLinkDto createLinkDto) {
        Link link = new Link(createLinkDto.getLink(), createLinkDto.getPassword(), 0, true);
        int responseId = linkRepository.createLink(link);

        return new ResponseCreateLinkDto(responseId);
    }

    @Override
    public String isActivatedUrl(int id, String password) {
        return null;
    }

    @Override
    public ResponseMetricDto sumRedirectLink(int id) {
        return null;
    }

    @Override
    public void disabledLink(int id) {

    }
}
