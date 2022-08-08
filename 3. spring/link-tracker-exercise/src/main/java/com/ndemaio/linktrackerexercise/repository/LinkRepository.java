package com.ndemaio.linktrackerexercise.repository;

import com.ndemaio.linktrackerexercise.model.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LinkRepository {

    private List<Link> links;

    public LinkRepository(){
        links = new ArrayList<>();
    }

    public void save(Link link){
        links.add(link);
    }

    public Optional<Link> getLinkById(UUID id){
        return links.stream().filter(link -> link.getId().equals(id)).findFirst();
    }

    public void update(Link anUpdatedLink) {
        links.removeIf(link -> link.getId().equals(anUpdatedLink.getId()));
        links.add(anUpdatedLink);
    }
}
