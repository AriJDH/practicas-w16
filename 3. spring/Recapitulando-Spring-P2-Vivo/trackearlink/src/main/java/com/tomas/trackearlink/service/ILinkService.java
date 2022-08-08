package com.tomas.trackearlink.service;

import com.tomas.trackearlink.dto.ExceptionDTO;
import com.tomas.trackearlink.dto.FullLinkDTO;
import com.tomas.trackearlink.dto.LinkDTO;
import com.tomas.trackearlink.dto.LinkIdDTO;

public interface ILinkService {

    LinkIdDTO saveLink(LinkDTO newLink);
    String redirect(int id, String password);
    FullLinkDTO getMetrics(int id);

    ExceptionDTO setInvalidate(int linkId);
}
