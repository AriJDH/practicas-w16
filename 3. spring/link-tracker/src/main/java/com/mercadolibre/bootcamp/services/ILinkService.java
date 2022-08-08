package com.mercadolibre.bootcamp.services;

import com.mercadolibre.bootcamp.dtos.FullLinkDto;
import com.mercadolibre.bootcamp.dtos.request.LinkDto;
import com.mercadolibre.bootcamp.dtos.response.LinkIdDto;

public interface ILinkService {

    public LinkIdDto saveLink(LinkDto newLink);
    public String redirect(int id);
    public FullLinkDto getMetrics(int id);
}
