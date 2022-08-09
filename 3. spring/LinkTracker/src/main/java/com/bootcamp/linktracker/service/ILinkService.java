package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.CreateLinkDto;
import com.bootcamp.linktracker.dto.ResponseCreateLinkDto;
import com.bootcamp.linktracker.dto.ResponseMetricDto;

public interface ILinkService {

    ResponseCreateLinkDto createLink(CreateLinkDto createLinkDto);

    String isActivatedUrl(int id, String password);

    ResponseMetricDto sumRedirectLink(int id);

    void disabledLink(int id);

}
