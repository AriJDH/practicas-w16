package com.meli.linktracker.service;

import com.meli.linktracker.dto.LinkDto;
import com.meli.linktracker.entity.Link;
import com.meli.linktracker.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlService {
    @Autowired
    private UrlRepository repository;

    private AtomicInteger count= new AtomicInteger();
    public boolean validarUrl(String url)
    {
        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(url);
        return matcher.find();

    }




    public String getUrl(int id)
    {
        return repository.getListaLink().stream().filter(x-> x.getId()==id).findFirst().orElse(null).getUrl();
    }


    public LinkDto getLink(int id)
    {
        return  repository.getListaLink().stream().filter(x->x.getId()==id).findFirst().get();
    }



    public void addSolicitudes(int id)
    {
        repository.getListaLink().stream().filter(x-> x.getId()==id).findFirst().get().addSolicitudes();
    }


    public LinkDto crearUrl(String url)
    {
        if(this.validarUrl(url)) {
            Link link = new Link(this.generateId(), url);
            LinkDto linkDto = new LinkDto(link.getId(), link.getUrl(), 0,true);
            repository.agregarLink(linkDto);

            return linkDto;

        }

        return null;
    }



    private int generateId()
    {
        return count.incrementAndGet();
    }

    public void  invalidateLink(int id)
    {
        this.repository.getLink(id).setValidate(false);
    }



}
