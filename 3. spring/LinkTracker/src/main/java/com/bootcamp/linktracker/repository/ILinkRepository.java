package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.entity.Link;

public interface ILinkRepository {

    int createLink(Link link);

    Link findById(int id);

    boolean hasId(int id);

}
