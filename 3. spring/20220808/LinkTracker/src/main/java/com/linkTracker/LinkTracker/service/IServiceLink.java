package com.linkTracker.LinkTracker.service;

import com.linkTracker.LinkTracker.dto.LinkResponseDTO;
import com.linkTracker.LinkTracker.dto.LinkResponseDataDTO;

import java.util.List;

public interface IServiceLink {

    LinkResponseDTO addLink(String x);
    LinkResponseDataDTO findLink(int id);
    List<LinkResponseDataDTO> findAll();
}
