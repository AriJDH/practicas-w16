package com.example.linktracker.repository;

import com.example.linktracker.dto.NewLinkDTO;
import com.example.linktracker.model.Link;

public interface ILinkRepository {

    public NewLinkDTO addLink(String url);
    public String getLinkViaId(Integer id);
    public Integer getStatistics(Integer id);
}
