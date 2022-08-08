package com.tomas.trackearlink.repository;

import com.tomas.trackearlink.Entity.Link;

public interface ILinkRepository {

    int addLink(Link newLink);
    Link getLinkById(int id);
    void updateLink(Link link);

    void updateIsActive(Link link);
}