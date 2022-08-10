package com.bootcamp.link.repository;

import com.bootcamp.link.entity.Link;

import java.util.HashMap;

public interface LinkRepository {
    Link findById(int id);
    Link createLink(Link link);
    void invalidateLink(int id);

    int getStatByLinkId(int id);
    HashMap<Integer, Link> getLinks();
}
