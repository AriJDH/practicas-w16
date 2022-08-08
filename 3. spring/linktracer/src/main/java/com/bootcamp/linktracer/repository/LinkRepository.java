package com.bootcamp.linktracer.repository;

import com.bootcamp.linktracer.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {
    private final Map<Integer,Link> links = new HashMap<>();


    @Override
    public boolean createLink(Link link) {
        if(links.containsKey(link.getId()))
            return false;
        links.put(link.getId(), link);
        return true;
    }

    @Override
    public Link getLink(int id) {
        return links.get(id);
    }

    @Override
    public boolean putLink(Link link) {
        if(!links.containsKey(link.getId()))
            return false;
        links.put(link.getId(), link);
        return true;
    }
}
