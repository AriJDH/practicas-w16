package com.bootcamp.linktracker.repository;

import com.bootcamp.linktracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LinkRepository implements IRepository {
    private HashMap<Long, Link> links;
    private Long id;

    public LinkRepository() {
        this.links = new HashMap<>();
        this.id = 1L;
    }

    public Link save(Link link){
        link.setViews(0L);
        link.setId(id++);
        links.put(link.getId(), link);
        return link;
    }

    public Link findById(Long id){
        return links.get(id);
    }

    public List<Link> findAll(){
        return links.values().stream().collect(Collectors.toList());
    }

    public Link findByUrl(String url){
        return this.links.values().stream()
                .filter(link -> link.getLink().equals(url))
                .findFirst()
                .orElse(null);
    }

    public Link findByIdAndPassword(Long id, String password){
        Link link = links.get(id);
        if(link == null) return null;
        if (link.getPassword().equals(password)) return link;
        return null;
    }

    @Override
    public void update(Long id, Link link) {
        this.links.put(id, link);
    }

    @Override
    public void delete(Long id) {
        this.links.remove(id);
    }
}
