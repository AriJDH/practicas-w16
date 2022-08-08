package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Data
@AllArgsConstructor
@Repository
public class BlogRepository{

    private HashMap<Integer, BlogEntry> blogEntries;
    public BlogRepository(){
        this.blogEntries = new HashMap<>();
    }

}
