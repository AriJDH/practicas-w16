package com.example.springlinktracker.repository;

import java.util.HashMap;

import com.example.springlinktracker.entity.Link;
import org.springframework.stereotype.Repository;

@Repository
public class LinkTrackerRepository implements ILinkTrackerRepository {
    private HashMap<Integer, Link> links;
    private Integer currentID;

    public LinkTrackerRepository() {
        this.links = new HashMap<>();
        this.currentID = 0;
    }

    @Override
    public Integer add(Link link) {
        this.currentID++;
        link.setId(this.currentID);
        links.put(this.currentID, link);

        return this.currentID;
    }

    @Override
    public Link getById(Integer id) {
        return links.get(id);
    }

    @Override
    public void update(Link link) {
        Link linkFound = this.getById(link.getId());
        if (linkFound != null)
            this.links.put(link.getId(), link);
    }
}
