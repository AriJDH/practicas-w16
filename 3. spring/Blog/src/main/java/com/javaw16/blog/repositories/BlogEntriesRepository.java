package com.javaw16.blog.repositories;

import com.javaw16.blog.entities.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogEntriesRepository implements IBlogEntriesRepository{

    HashMap<Integer, BlogEntry> blogEntries;

    @Override
    public void loadEntry(BlogEntry blogEntry) {
        blogEntries.put(blogEntry.getId(), blogEntry);
    }

    @Override
    public BlogEntry returnEntry(Integer id) {
        return blogEntries.get(id);
    }

    @Override
    public List<BlogEntry> returnAsList() {
        List<BlogEntry> valuesList = new ArrayList<>();
        List<Integer> keysList = new ArrayList<>(blogEntries.keySet());

        for (Integer integer : keysList) {
            valuesList.add(blogEntries.get(integer));
        }

        return valuesList;
    }

}
