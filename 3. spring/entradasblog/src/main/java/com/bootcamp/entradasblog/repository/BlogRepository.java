package com.bootcamp.entradasblog.repository;

import com.bootcamp.entradasblog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BlogRepository implements IBlogRepository{

    HashMap<Integer, Blog> blogs ;

    public BlogRepository(){
        this.blogs = new HashMap<>();
    }

    @Override
    public void addBlog(Blog b) {
        blogs.put(b.getId(), b);
    }

    @Override
    public Blog getBlog(int id) {
        return blogs.get(id);
    }

    @Override
    public boolean existsBlog(int id) {
        return blogs.containsKey(id);
    }

    @Override
    public List<Blog> getBlogs() {
        return blogs.values().stream().collect(Collectors.toList());
    }
}
