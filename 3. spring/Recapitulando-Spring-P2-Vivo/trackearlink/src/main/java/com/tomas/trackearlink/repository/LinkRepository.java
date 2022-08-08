package com.tomas.trackearlink.repository;

import com.tomas.trackearlink.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {
    private Map<Integer, Link> links = new HashMap<>();

    public int addLink(Link newLink){
        newLink.setId(links.size());
        links.put(links.size(),newLink);
        return newLink.getId();
    }

    public Link getLinkById(int id){
        return links.get(id);
    }

    public void updateLink(Link link){
        links.put(link.getId(),link);
    }

    public void updateIsActive(Link link){
        link.setActive(false);
        links.put(link.getId(), link);
    }

}