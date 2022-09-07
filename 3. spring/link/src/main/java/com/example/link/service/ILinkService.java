package com.example.link.service;

import com.example.link.dto.CreateLinkDto;
import com.example.link.dto.ResponseCreateLinkDto;

public interface ILinkService {

    ResponseCreateLinkDto createLink(CreateLinkDto createLinkDto);
}
