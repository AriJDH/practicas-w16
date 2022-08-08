package com.linktracker.linktracker.service;

import com.linktracker.linktracker.dto.RequestLinkDTO;
import com.linktracker.linktracker.dto.ResponseLinkDTO;

public interface IService {
    
    ResponseLinkDTO addLink(RequestLinkDTO link);
    boolean validateLink(String link);
    String getLink(Integer ID);
    Integer getRedirections(Integer ID);
    boolean invalidateLink(Integer ID);
    String getLinkAuthorizated(Integer ID, String password);
}
