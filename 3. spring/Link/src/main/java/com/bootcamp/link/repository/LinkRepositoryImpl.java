package com.bootcamp.link.repository;

import com.bootcamp.link.entity.Link;
import com.bootcamp.link.exception.InvalidUrlException;
import com.bootcamp.link.exception.LinkNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    private HashMap<Integer, Link> links;
    private HashMap<Integer, Integer> stats;

    public LinkRepositoryImpl() {
        this.links = new HashMap<>();
        this.stats = new HashMap<>();
    }

    @Override
    public Link findById(int id) {
        if (links.containsKey(id))
        {
            Link linkFound = links.get(id);
            if (stats.containsKey(id)){
                stats.put(id, stats.get(id)+1);
            }else{
                stats.put(id, 1);
            }
            return linkFound;
        }
        return null;
    }

    @Override
    public Link createLink(Link link) {
        Random random = new Random();
        int newIndex = random.nextInt(999999);
        link.setId(newIndex);
        links.put(newIndex, link);
        return link;
    }

    @Override
    public void invalidateLink(int id) {
        links.remove(id);
    }

    @Override
    public int getStatByLinkId(int id) {
        if (stats.containsKey(id)){
            return stats.get(id);
        }else {
            return 0;
        }
    }

    @Override
    public HashMap<Integer, Link> getLinks() {
        return links;
    }



}
