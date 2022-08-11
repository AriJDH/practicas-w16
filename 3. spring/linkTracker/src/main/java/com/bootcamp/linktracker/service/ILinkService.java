package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.InvalidateDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.dto.LinkMetricDTO;
import com.bootcamp.linktracker.dto.LinkResponseDTO;

public interface ILinkService {

    LinkResponseDTO createLinkService(LinkDTO linkDTO);

    LinkDTO redirectService(Integer id, String password);

    LinkMetricDTO metricService(Integer id);

    InvalidateDTO invalidate(Integer linkId);
}
