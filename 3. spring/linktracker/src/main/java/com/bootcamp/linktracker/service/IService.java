package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.request.LinkReqDTO;
import com.bootcamp.linktracker.dto.response.LinkCreatedResDTO;
import com.bootcamp.linktracker.dto.response.LinkMetricsResDTO;
import com.bootcamp.linktracker.dto.response.LinkResDTO;
import com.bootcamp.linktracker.entity.Link;

import java.util.List;

public interface IService{
    LinkResDTO findById(Long id);
    List<LinkResDTO> findAll();
    LinkCreatedResDTO save(LinkReqDTO model);
    LinkResDTO findByIdAndPassword(Long id, String password);
    LinkMetricsResDTO getLinkMetrics(Long id);
    void delete(Long id);
}
