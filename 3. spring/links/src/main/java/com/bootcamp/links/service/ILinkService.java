package com.bootcamp.links.service;

import com.bootcamp.links.dto.InvalidateLinkDto;
import com.bootcamp.links.dto.NewLinkDto;
import com.bootcamp.links.dto.RequestNewLinkDto;
import com.bootcamp.links.dto.StadisticLinkDto;
import org.springframework.http.HttpHeaders;

public interface ILinkService {

    public NewLinkDto addLink(RequestNewLinkDto requestDto, String password);

    public HttpHeaders redirect(Integer id, String password);

    public StadisticLinkDto getStadistics(Integer id);

    public InvalidateLinkDto invalidateLink(Integer id);
}
