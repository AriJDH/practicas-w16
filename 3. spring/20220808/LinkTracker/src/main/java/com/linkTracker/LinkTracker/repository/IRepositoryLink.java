package com.linkTracker.LinkTracker.repository;

import com.linkTracker.LinkTracker.model.Link;

import java.util.HashMap;

public interface IRepositoryLink {

    void addLink(Link n);

    Link findLink(int id);

    HashMap<Integer, Link> findAll();

}
