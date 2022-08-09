package com.bootcamp.link.service;

import com.bootcamp.link.dto.CreateLinkDto;
import com.bootcamp.link.dto.ResponseCreateLinkDto;
import com.bootcamp.link.dto.ResponseMetricsDto;

public interface ILinkService {

    ResponseCreateLinkDto createLink(CreateLinkDto createLinkDto);

    String isValidUrl(int id, String password);

    ResponseMetricsDto sumRedirectLink(int id);
}
