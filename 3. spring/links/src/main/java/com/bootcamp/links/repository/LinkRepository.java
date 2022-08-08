package com.bootcamp.links.repository;

import com.bootcamp.links.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository{

    private HashMap<Integer, Link> links;

    public LinkRepository (){
        this.links = new HashMap<>();
    }
    public void addLink(Link link, Integer id){
        links.put(id, link);
    }

    @Override
    public boolean exists(Integer id) {
        return links.containsKey(id);
    }

    @Override
    public Link getLink(Integer id) {
        return links.get(id);
    }


}
