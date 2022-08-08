package com.JavaW16.linkTracker.service;

import com.JavaW16.linkTracker.dto.LinkDTO;
import com.JavaW16.linkTracker.dto.ResponseDTO;
import com.JavaW16.linkTracker.dto.StatisticsDTO;
import com.JavaW16.linkTracker.entity.Link;

public interface ILinkService {
    ResponseDTO cargarDatos(LinkDTO linkDTO);
    String redirect(Integer linkId, String linkPassword);
    StatisticsDTO traerStatistic(Integer linkId);
    LinkDTO invalidarLink(Integer linkId);
}
