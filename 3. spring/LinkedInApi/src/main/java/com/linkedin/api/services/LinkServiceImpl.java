package com.linkedin.api.services;

import com.linkedin.api.dtos.LinkDTO;
import com.linkedin.api.dtos.MetricDTO;
import com.linkedin.api.entities.Link;
import com.linkedin.api.exceptions.BadUrlException;
import com.linkedin.api.exceptions.NotFoundException;
import com.linkedin.api.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    private LinkRepository linkRepository;


    @Override
    public LinkDTO saveLink(Link link) throws Exception {

        if (valideUrl(link.getUrl())){
            return linkRepository.saveLink(new Link((long) linkRepository.getLinks().size(),link.getUrl(),0,true));
        }

        throw new BadUrlException("la Url no tiene el formato adecuado");



    }

    @Override
    public String getLink(Long id) throws NotFoundException {
        return linkRepository.getLink(id).getUrl();


    }

    @Override
    public MetricDTO getMetric(Long id) {
        return linkRepository.getMetric(id);
    }

    @Override
    public LinkDTO invalid(Long id) throws NotFoundException {
        return linkRepository.invalidLink(id);
    }

    private boolean valideUrl(String url){
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(url);
        return matcher.matches();
    }
}
