package com.mercadolibre.bootcamp.repositories;

import com.mercadolibre.bootcamp.models.BlogEntry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class BlogRepository {
    List<BlogEntry> blogEntries = new ArrayList<>();

    public BlogEntry findById(int id) {
        return blogEntries
                .stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void createEntry (BlogEntry blogEntry){
        blogEntries.add(blogEntry);
    }

    public List<BlogEntry> getAllEntries(){
        return blogEntries;
    }
}
