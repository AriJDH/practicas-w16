package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entity.Link;

public interface IRepository {
    public Link getLink(Integer ID);
    public Integer addLink(Link link);
    public boolean invalidateLink(Integer ID);
}
