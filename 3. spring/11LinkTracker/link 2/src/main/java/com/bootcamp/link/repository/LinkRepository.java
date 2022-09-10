package com.bootcamp.link.repository;

import com.bootcamp.link.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository{

    Map<Integer, Link> dataLink = new HashMap<>();
    int idCounter = 0;

    @Override
    public int createLink(Link link) {
        ++idCounter;
        dataLink.put(idCounter, link);
        return idCounter;
    }

    @Override
    public Link findById(int id) {
        return dataLink.get(id);
    }

    @Override
    public boolean hasId(int id) {
        return dataLink.containsKey(id);
    }
}
