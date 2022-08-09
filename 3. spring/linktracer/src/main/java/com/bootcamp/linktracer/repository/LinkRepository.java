package com.bootcamp.linktracer.repository;

import com.bootcamp.linktracer.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {
    private final Map<Integer,Link> links = new HashMap<>();
    private int counter = 0;


    @Override
    public Link createLink(Link link) {
        link.setId(++counter);
        links.put(link.getId(), link);
        return link;
    }

    @Override
    public Link getLink(int id) {
        return links.get(id);
    }
}
