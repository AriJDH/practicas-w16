package com.spring.Blog.repository;

import com.spring.Blog.model.Blog;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BlogRepository implements IBlogRepository{
    private Map<Integer, Blog> blogMap;

    public BlogRepository() {
        this.blogMap = new HashMap<>();
    }


    @Override
    public void addBlog(Blog blog) {
        blogMap.put(blog.getIdBlog(),blog);
    }

    @Override
    public Blog getBlog(int id) {
        return blogMap.get(id);
    }

    @Override
    public List<Blog> blogs() {
        return blogMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public boolean existBlog(int id) {
        return blogMap.containsKey(id);
    }

}
