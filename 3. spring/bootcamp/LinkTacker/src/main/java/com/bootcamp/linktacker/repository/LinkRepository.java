package com.bootcamp.linktacker.repository;

import com.bootcamp.linktacker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    private List<Link> links = new ArrayList<>();

    @Override
    public void createLink(Link link) {
        links.add(new Link(link.getId(), link.getLink(), link.isValid(), link.getPassword(), link.getMetric()));
    }

    @Override
    public Link getLinkById(Integer id) {
        return links.stream().filter(link -> link.getId().intValue() == id)
                .findFirst().get();
    }

    @Override
    public List<Link> getAllLinks() {
        return links;
    }
}
