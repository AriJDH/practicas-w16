package com.example.link.repository;

import com.example.link.entity.Link;

import java.util.HashMap;
import java.util.Map;

public class LinkRepository implements ILinkRepository{

    Map<Integer,Link> dataLink = new HashMap<>();
    int idCount =0;

    @Override
    public int createLink(Link link) {
        ++idCount;
        dataLink.put(idCount,link);
        return idCount;
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
