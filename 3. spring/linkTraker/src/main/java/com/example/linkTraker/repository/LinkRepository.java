package com.example.linkTraker.repository;

import com.example.linkTraker.dto.LinkIdDto;
import com.example.linkTraker.model.Link;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Repository
public class LinkRepository {

    private Map<Link, Integer> links;

    public LinkRepository() {
        this.links = new HashMap<>();
    }

    public boolean addLink(Link link){

        if (links.get(link) == null){
            links.put(link,0);
            return true;
        }
        return false;
    }
}
