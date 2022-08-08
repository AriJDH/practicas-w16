package com.example.linktracker.repository;

import com.example.linktracker.dto.NewLinkDTO;
import com.example.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class LinkRepository implements ILinkRepository {

    private HashMap<Integer, Link> links = new HashMap<>();
    private Integer id = 0;

    @Override
    public NewLinkDTO addLink(String url) {
        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(url);
       if(matcher.matches()){
            id++;
            links.put(this.id, new Link(url,"",0));
        }

        return new NewLinkDTO(id);
    }

    public String getLinkViaId(Integer id){
        links.get(id).addCount();
        return links.get(id).getUrl();
    }

    public Integer getStatistics(Integer id){
        return links.get(id).getCount();
    }

}
