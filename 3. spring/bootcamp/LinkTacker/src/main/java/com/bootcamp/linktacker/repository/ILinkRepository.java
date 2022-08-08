package com.bootcamp.linktacker.repository;

import com.bootcamp.linktacker.entity.Link;

import java.util.List;

public interface ILinkRepository {

    void createLink(Link link);
    Link getLinkById(Integer id);
    List<Link> getAllLinks();
}
