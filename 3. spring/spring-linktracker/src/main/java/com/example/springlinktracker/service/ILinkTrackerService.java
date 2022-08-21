package com.example.springlinktracker.service;

import com.example.springlinktracker.dto.RequestPostLinkDTO;
import com.example.springlinktracker.dto.ResponsePostLinkDTO;

public interface ILinkTrackerService {
    ResponsePostLinkDTO addLink(RequestPostLinkDTO link);

    String getLink(Integer ID, String password);

    Integer getLinkRedirectionsCount(Integer ID);

    void invalidateLink(Integer ID);
}
