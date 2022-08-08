package com.bootcamp.links.service;

import com.bootcamp.links.dto.InvalidateLinkDto;
import com.bootcamp.links.dto.NewLinkDto;
import com.bootcamp.links.dto.RequestNewLinkDto;
import com.bootcamp.links.dto.StadisticLinkDto;
import com.bootcamp.links.exception.NoMatchException;
import com.bootcamp.links.exception.NotFoundException;
import com.bootcamp.links.exception.NotValidException;
import com.bootcamp.links.exception.PasswordMissmatchException;
import com.bootcamp.links.model.Link;
import com.bootcamp.links.repository.ILinkRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkService implements ILinkService{
    private int count;

    private ILinkRepository linkRepository;

    public LinkService (ILinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    public NewLinkDto addLink(RequestNewLinkDto requestDto, String password) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(requestDto.getUrl());
        if (matcher.matches()) {
            int id = count;
            linkRepository.addLink(new Link(requestDto.getUrl(), true, 0, password), id);
            count++;
            return new NewLinkDto(id);
        }
        else{
            throw new NoMatchException(requestDto.getUrl());
        }
    }

    @Override
    public HttpHeaders redirect(Integer id, String password){
        if (linkRepository.exists(id)){
            Link link = linkRepository.getLink(id);
            if (link.getPassword().equals(password)) {
                if (link.isValid()) {
                    HttpHeaders httpHeaders = new HttpHeaders();
                    try {
                        URI url = new URI(link.getValue());
                        httpHeaders.setLocation(url);

                        //sumo 1 a la estadística
                        link.setCount(link.getCount() + 1);

                        return httpHeaders;
                    } catch (URISyntaxException e) {
                        throw new NoMatchException(linkRepository.getLink(id).getValue());
                    }
                } else throw new NotValidException();
            }
            else throw new PasswordMissmatchException();
        }
        else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public StadisticLinkDto getStadistics(Integer id) {
        if (linkRepository.exists(id)){
            return new StadisticLinkDto(linkRepository.getLink(id).getCount());
        }
        else{
            throw new NotFoundException(id);
        }
    }

    @Override
    public InvalidateLinkDto invalidateLink(Integer id) {
        if (linkRepository.exists(id)){
           Link link =linkRepository.getLink(id);
           link.setValid(false);

           return new InvalidateLinkDto("Link invalidado correctamente");
        }
        else{
            throw new NotFoundException(id);
        }
    }


}
