package com.example.link.service;

import com.example.link.Exceptions.InvalidLinkException;
import com.example.link.dto.CreateLinkDto;
import com.example.link.dto.ResponseCreateLinkDto;
import com.example.link.entity.Link;
import com.example.link.repository.ILinkRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkService implements ILinkService{

    private final ILinkRepository linkRepository;

    public LinkService(ILinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    public ResponseCreateLinkDto createLink(CreateLinkDto createLinkDto) {
        UrlValidator defaultValidatos = new UrlValidator();
        boolean isValid = defaultValidatos.isValid(createLinkDto.getLink());
        if(!isValid){
            throw new InvalidLinkException();
        }
        Link link = new Link(createLinkDto.getLink(),createLinkDto.getPassword(),0,true);
        return null;
    }
}
