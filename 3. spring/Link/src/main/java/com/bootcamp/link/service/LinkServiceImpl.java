package com.bootcamp.link.service;

import com.bootcamp.link.dto.RequestCreateLinkDTO;
import com.bootcamp.link.dto.RequestFindLinkDTO;
import com.bootcamp.link.dto.ResponseLinkDTO;
import com.bootcamp.link.entity.Link;
import com.bootcamp.link.exception.InvalidPasswordLinkException;
import com.bootcamp.link.exception.InvalidUrlException;
import com.bootcamp.link.exception.LinkNotFoundException;
import com.bootcamp.link.repository.LinkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    LinkRepository linkRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public ResponseLinkDTO createLink(RequestCreateLinkDTO link) {
        if (!validateUrl(link)){
            throw new InvalidUrlException();
        }
        Link linkNuevo = mapper.map(link, Link.class);
        linkNuevo = linkRepository.createLink(linkNuevo);
        ResponseLinkDTO responseLinkDTO = mapper.map(linkNuevo, ResponseLinkDTO.class);
        return responseLinkDTO;
    }

    @Override
    public ResponseLinkDTO findById(RequestFindLinkDTO linkData) {
        validateLinkPassword(linkData);
        Link linkToFind = linkRepository.findById(linkData.getId());
        ResponseLinkDTO responseLinkDTO = mapper.map(linkToFind, ResponseLinkDTO.class);
        return responseLinkDTO;
    }

    @Override
    public void invalidateLink(int linkId) {
        linkRepository.invalidateLink(linkId);
    }

    @Override
    public int getStatsLinkById(int id) {
        return linkRepository.getStatByLinkId(id);
    }

    private boolean validateUrl(RequestCreateLinkDTO link){
        String regex = "((http|https)://)(www.)?"
        + "[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]"
        + "{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
        try {
            Pattern patt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = patt.matcher(link.getUrl());
            return matcher.matches();
        } catch (PatternSyntaxException e) {
            throw new InvalidUrlException();
        }
    }

    private void validateLinkPassword(RequestFindLinkDTO link){
        if (linkRepository.getLinks().containsKey(link.getId())){
            if (!linkRepository.getLinks().get(link.getId()).getPassword().equals(link.getPassword())){
                throw new InvalidPasswordLinkException();
            }
        }else{
            throw new LinkNotFoundException();
        }
    }
}
