package com.bootcamp.link.service;

import com.bootcamp.link.dto.RequestCreateLinkDTO;
import com.bootcamp.link.dto.RequestFindLinkDTO;
import com.bootcamp.link.dto.ResponseLinkDTO;

public interface LinkService {
    ResponseLinkDTO createLink(RequestCreateLinkDTO link);
    ResponseLinkDTO findById(RequestFindLinkDTO linkData);
    void invalidateLink(int linkId);

    int getStatsLinkById(int id);
}
