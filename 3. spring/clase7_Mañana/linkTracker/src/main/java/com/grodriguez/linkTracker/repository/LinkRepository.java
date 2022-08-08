package com.grodriguez.linkTracker.repository;

import com.grodriguez.linkTracker.entities.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    private List<Link> links;

    public LinkRepository() {
        this.links = new ArrayList<>();
    }


    @Override
    public int createLink(String url, String password) {

        Link link = new Link(links.size() + 1, password, url, 0, true);
        links.add(link);

        return link.getId();
    }

    @Override
    public Link getLink(int id, String password) {
        Link link = links.get(id - 1);

        if(link.getPassword().equals(password) && link.isValid())
            return link;
        else
            return null;
    }

    public Link getLink(int id) {
        Link link = links.get(id - 1);

        if(link.isValid())
            return link;
        else
            return null;
    }

    @Override
    public void addRedirection(int id) {
        Link l = links.get(id - 1);
        l.setRedireccions(l.getRedireccions() + 1);
    }

    @Override
    public boolean invalidateLink(int id) {

        try{
            links.get(id - 1).setValid(false);
            return true;
        }
        catch(IndexOutOfBoundsException e){
            return false;
        }
    }
}
