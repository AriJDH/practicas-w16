package com.bootcamp.links.repository;

import com.bootcamp.links.model.Link;

public interface ILinkRepository {

    public void addLink(Link link, Integer id);
    public boolean exists(Integer id);
    public Link getLink(Integer id);
}
