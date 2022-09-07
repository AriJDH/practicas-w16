package com.example.link.repository;

import com.example.link.entity.Link;

public interface ILinkRepository {

    int createLink(Link link);

    Link findById(int id);

    boolean hasId(int id);
}
