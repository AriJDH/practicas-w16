package com.bootcamp.linktacker.service;

import com.bootcamp.linktacker.dto.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ILinkService {

    CreatedLinkDto createLink(LinkDto linkDto);
    List<AllInfoLinkDto> showAllLinks();
    void redirect(Integer id, HttpServletResponse response, String password);
    MetricResponseDto metrics(Integer id);

    ApiResponseDto invalidateLink(Integer id);
}
