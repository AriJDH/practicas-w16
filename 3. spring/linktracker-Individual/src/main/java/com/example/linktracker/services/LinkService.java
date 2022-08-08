package com.example.linktracker.services;

import com.example.linktracker.dto.NewLinkDTO;
import com.example.linktracker.dto.RequestNewLinkDTO;
import com.example.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    @Autowired
    ILinkRepository repository;

    @Override
    public NewLinkDTO addNewLink(RequestNewLinkDTO requestNewLinkDTO) {
        return repository.addLink(requestNewLinkDTO.getUrl());
    }

    public String getLink(Integer id){
        return repository.getLinkViaId(id);
    }

    public Integer getLinkStatistics(Integer id){
        return repository.getStatistics(id);
    }



}
