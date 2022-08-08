package com.linktracker.linktracker.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.linktracker.linktracker.entity.Link;

@Repository
public class LinkTrackerRepository implements IRepository{
    private final HashMap<Integer, Link> links;
    private Integer currentID;

    public LinkTrackerRepository() {
        this.links = new HashMap<>();
        this.currentID = 1;
    }

    @Override
    public Link getLink(Integer ID){
        return links.get(ID);
    }

    @Override
    public Integer addLink(Link link){
        link.setValid(true);

        links.put(currentID, link);
        return currentID++;
    }

    @Override
    public boolean invalidateLink(Integer ID){
        Link link = links.get(ID);
        if(link != null){
            link.setValid(false);
            return true;
        }
        return false;
    }

}
