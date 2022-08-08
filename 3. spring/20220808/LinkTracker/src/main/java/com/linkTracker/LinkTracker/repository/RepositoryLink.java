package com.linkTracker.LinkTracker.repository;

import com.linkTracker.LinkTracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class RepositoryLink implements IRepositoryLink {

    HashMap<Integer, Link> list;
    private int id = 0;

    public RepositoryLink(){
        list = new HashMap<>();
    }

    @Override
    public void addLink(Link n) {
        list.put(id, n);
        id++;

    }

    @Override
    public Link findLink(int id) {
        return list.get(id);
    }

    @Override
    public HashMap<Integer, Link> findAll() {
        return list;
    }
}
