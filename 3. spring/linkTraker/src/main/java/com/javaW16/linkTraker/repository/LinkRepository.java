package com.javaW16.linkTraker.repository;

import com.javaW16.linkTraker.model.Link;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Repository
public class LinkRepository {

   private Map<String, Link> links;
   private Map<Integer, String> invertLinks;
   private Integer id;

   public LinkRepository() {
      this.links = new HashMap<>();
      this.invertLinks = new HashMap<>();
      this.id = 1;
   }

   public void addLink(Link link) {
      links.put(link.getUrl(), link);
      invertLinks.put(link.getId(), link.getUrl());
      this.id += 1;
   }

   public void plusOneVisit(String url) {
      links.get(url).setNVisits(links.get(url).getNVisits() + 1);
   }

   public void deleteById(String url, Integer id) {
      links.remove(url);
      invertLinks.remove(id);
   }

}
