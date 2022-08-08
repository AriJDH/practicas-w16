package com.linkedin.api.services;

import com.linkedin.api.dtos.LinkDTO;
import com.linkedin.api.dtos.MetricDTO;
import com.linkedin.api.entities.Link;
import com.linkedin.api.exceptions.NotFoundException;

public interface LinkService {
    public LinkDTO saveLink(Link link) throws Exception;
    public String getLink(Long id) throws NotFoundException;
    public MetricDTO getMetric(Long id);
    public LinkDTO invalid(Long id) throws NotFoundException;
}
