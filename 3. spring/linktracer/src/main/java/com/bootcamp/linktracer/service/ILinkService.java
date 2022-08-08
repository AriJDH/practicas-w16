package com.bootcamp.linktracer.service;

import com.bootcamp.linktracer.dto.RequestLinkDTO;
import com.bootcamp.linktracer.dto.ResponseActiveDTO;
import com.bootcamp.linktracer.dto.ResponseLinkDTO;
import com.bootcamp.linktracer.dto.ResponseLinkMetricsDTO;

public interface ILinkService {
    ResponseLinkDTO createLink(RequestLinkDTO link);

    String redirect(int id, String password);

    ResponseLinkMetricsDTO getLinkMetrics(int id, String password);

    ResponseActiveDTO deactivateLink(int id, String password);

    ResponseActiveDTO activateLink(int id, String password);
}
