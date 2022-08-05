package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BlogRepositoryImpl implements BlogRepository{

    private Map<Integer, EntradaBlog> blogs;

    public BlogRepositoryImpl(){
        blogs = new HashMap<>();
        EntradaBlog blog1 = new EntradaBlog(1, "Blog 1", "Author 1", LocalDate.now());
        EntradaBlog blog2 = new EntradaBlog(2, "Blog 2", "Author 1", LocalDate.now());
        EntradaBlog blog3 = new EntradaBlog(3, "Blog 3", "Author 2", LocalDate.now());
        EntradaBlog blog4 = new EntradaBlog(4, "Blog 4", "Author 2", LocalDate.now());
        blogs.put(blog1.getId(), blog1);
        blogs.put(blog2.getId(), blog2);
        blogs.put(blog3.getId(), blog3);
        blogs.put(blog4.getId(), blog4);
    }

    @Override
    public List<EntradaBlog> listarBlogs() {
        return blogs.values().stream().collect(Collectors.toList());
    }

    @Override
    public EntradaBlog agregar(EntradaBlog blog) {
        if (blogs.keySet().contains(blog.getId())){
            return null;
        }
        blogs.put(blog.getId(), blog);
        return blog;
    }

    @Override
    public EntradaBlog buscarBlog(int id) {
        EntradaBlog blog = null;

        for (Map.Entry<Integer, EntradaBlog> entry: blogs.entrySet()) {
            if (entry.getKey() == id) {
                blog = entry.getValue();
            }
        }
        return blog;
    }
}
