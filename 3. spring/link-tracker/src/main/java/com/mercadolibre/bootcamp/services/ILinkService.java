package com.mercadolibre.bootcamp.services;

import com.mercadolibre.bootcamp.dtos.FullLinkDto;
import com.mercadolibre.bootcamp.dtos.request.LinkDto;
import com.mercadolibre.bootcamp.dtos.response.ExceptionDto;
import com.mercadolibre.bootcamp.dtos.response.LinkIdDto;

public interface ILinkService {

    public LinkIdDto saveLink(LinkDto newLink);
    public String redirect(int id, String password);
    public FullLinkDto getMetrics(int id);

    ExceptionDto setInvalidate(int linkId);
}
