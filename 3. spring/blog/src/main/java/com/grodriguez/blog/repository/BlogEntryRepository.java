package com.grodriguez.blog.repository;

import com.grodriguez.blog.entities.BlogEntry;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogEntryRepository implements IBlogEntryRepository {

    private List<BlogEntry> blogentryDB;

    public BlogEntryRepository(){
        loadData();
    }

    @Override
    public String createBlogEntry(BlogEntry be) {
        blogentryDB.add(be);
        return "Se creo correctamente la entrada al blog con el ID: " + be.getId();
    }

    @Override
    public BlogEntry getBlogEntry(int id) {
        return blogentryDB.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<BlogEntry> getAll() {
        return blogentryDB;
    }

    private void loadData(){
        blogentryDB = new ArrayList<>();
        blogentryDB.add(new BlogEntry(1,"Titulo 1", "German", LocalDate.now()));
        blogentryDB.add(new BlogEntry(2,"Titulo 2", "Romina", LocalDate.now()));
        blogentryDB.add(new BlogEntry(3,"Titulo 3", "Oliver", LocalDate.now()));
        blogentryDB.add(new BlogEntry(4,"Titulo 4", "Eduardo", LocalDate.now()));
        blogentryDB.add(new BlogEntry(5,"Titulo 5", "Nikita", LocalDate.now()));
        blogentryDB.add(new BlogEntry(6,"Titulo 6", "Leon", LocalDate.now()));
        blogentryDB.add(new BlogEntry(7,"Titulo 7", "Manuel", LocalDate.now()));
        blogentryDB.add(new BlogEntry(8,"Titulo 8", "Patricia", LocalDate.now()));
    }
}
