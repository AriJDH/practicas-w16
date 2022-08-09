package com.bootcamp.linktracker.repository;


import com.bootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    private final Map<Integer, Link> database = new HashMap<>();


    @Override
    public Link save(Link link) {
        if(link.getLinkId() == null)
            link.setLinkId(database.size());

        database.put(link.getLinkId(), link);
        return link;
    }

    @Override
    public Optional<Link> findLinkById(Integer id) {
        Link link = database.get(id);
        return Optional.ofNullable(link);
    }

    @Override
    public void delete(Link link) { database.remove(link.getLinkId()); }

}
