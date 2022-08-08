package com.JavaW16.linkTracker.service;

import com.JavaW16.linkTracker.dto.LinkDTO;
import com.JavaW16.linkTracker.dto.ResponseDTO;
import com.JavaW16.linkTracker.dto.StatisticsDTO;
import com.JavaW16.linkTracker.entity.Link;
import com.JavaW16.linkTracker.exception.*;
import com.JavaW16.linkTracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired
    ILinkRepository linkRepository;

    private static final String URL_REGEX =("((http|https)://)(www.)?" +
            "[a-zA-Z0-9@:%._\\+~#?&//=]" +
            "{2,256}\\.[a-z]" +
            "{2,6}\\b([-a-zA-Z0-9@:%" +
            "._\\+~#?&//=]*)");

    private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    @Override
    public boolean urlValidator(String url)
    {
        if (url == null) {
            return false;
        }

        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }

    @Override
    public ResponseDTO cargarDatos(LinkDTO linkDTO) {
        Link aux = linkRepository.traerDatos(linkDTO.getLinkId());
        if (aux!=null){
            throw new LinkIdCreated(linkDTO.getLinkId());
        }
        if (!urlValidator(linkDTO.getLinkURL())){
            throw new LinkUrlNotValidated(linkDTO.getLinkURL());
        }
        Link link = new Link(linkDTO.getLinkId(), linkDTO.getLinkURL(), linkDTO.getLinkPassword(), 0, true);
        ResponseDTO response = linkRepository.cargarDatos(link);
        return response;
    }

    @Override
    public String redirect(Integer linkId, String linkPassword) {
        Link aux = linkRepository.traerDatos(linkId);
        if (aux==null){
            throw new LinkNotFound(linkId);
        }
        if (aux.getLinkPassword().equals(linkPassword)){
            if(aux.getIsValid()){
                aux.setRedirectCounter(aux.getRedirectCounter()+1);
                return aux.getLinkURL();
            }else{
                throw new LinkIsNotValid(linkId);
            }
        } throw new LinkPasswordIncorrect(linkPassword);
    }

    @Override
    public StatisticsDTO traerStatistic(Integer linkId) {
        Link aux = linkRepository.traerDatos(linkId);
        if (aux==null){
            throw new LinkNotFound(linkId);
        }
        StatisticsDTO stats = new StatisticsDTO(aux.getRedirectCounter());
        return stats;
    }

    @Override
    public LinkDTO invalidarLink(Integer linkId) {
        Link aux = linkRepository.traerDatos(linkId);
        if (aux==null){
            throw new LinkNotFound(linkId);
        }
        aux.setIsValid(false);
        LinkDTO response = new LinkDTO(aux.getLinkId(), aux.getLinkURL(), aux.getLinkPassword());
        return response;
    }
}
