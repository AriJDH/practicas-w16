package com.example.linktracker.services;

import com.example.linktracker.dto.NewLinkDTO;
import com.example.linktracker.dto.RequestNewLinkDTO;

public interface ILinkService {

    public NewLinkDTO addNewLink(RequestNewLinkDTO requestNewLinkDTO);
    public String getLink(Integer id);
    public Integer getLinkStatistics(Integer id);
}
