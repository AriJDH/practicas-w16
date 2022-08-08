package com.grodriguez.linkTracker.service;

import com.grodriguez.linkTracker.DTO.*;
import org.springframework.web.servlet.ModelAndView;

public interface ILinkService {

    LinkDTO createLink(RequestLinkDTO link);
    String redirectLink(int id, String password);
    StatisticsDTO getLinkStatistics(int id);
    MessageDTO invalidateLink(int id);
}
