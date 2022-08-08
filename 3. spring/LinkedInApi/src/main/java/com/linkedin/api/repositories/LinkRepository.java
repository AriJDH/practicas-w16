package com.linkedin.api.repositories;

import com.linkedin.api.dtos.LinkDTO;
import com.linkedin.api.dtos.MetricDTO;
import com.linkedin.api.entities.Link;
import com.linkedin.api.exceptions.NotFoundException;

import java.util.List;

public interface LinkRepository {

    public LinkDTO saveLink(Link link);
    public LinkDTO getLink(Long id) throws NotFoundException;
    public List<LinkDTO> getLinks();
    public MetricDTO getMetric(Long id);

    public LinkDTO invalidLink(Long id) throws NotFoundException;
}
