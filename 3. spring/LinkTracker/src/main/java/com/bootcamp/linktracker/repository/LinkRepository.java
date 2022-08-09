package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {

    Map<Integer, Link> datalink = new HashMap<>();
    int idCounter = 0;


    @Override
    public int createLink(Link link) {
        ++idCounter;
        datalink.put(idCounter, link);
        return idCounter;
    }

    @Override
    public Link findById(int id) {
        return datalink.get(id);
    }

    @Override
    public boolean hasId(int id) {
        return datalink.containsKey(id);
    }

}

