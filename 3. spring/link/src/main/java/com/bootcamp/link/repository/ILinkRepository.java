package com.bootcamp.link.repository;


import com.bootcamp.link.entity.Link;

public interface ILinkRepository {

    int createLink(Link link);

    Link findById(int id);

    boolean hasId(int id);
}
