package com.javaW16.linkTraker.service;

import com.javaW16.linkTraker.dto.LinkDto;
import com.javaW16.linkTraker.dto.ResponseDeletedDTO;
import com.javaW16.linkTraker.dto.ResponseMetricsDTO;
import com.javaW16.linkTraker.dto.ResponseNewLinkDTO;

public interface ILinkService {

   public ResponseNewLinkDTO createLinkService(LinkDto link) throws Exception;

   public String redirectLinkService(Integer id,Integer password);

   public ResponseMetricsDTO getMetricsByIdService(Integer id);

   public ResponseDeletedDTO deleteLinkByIdService(Integer id);

}
