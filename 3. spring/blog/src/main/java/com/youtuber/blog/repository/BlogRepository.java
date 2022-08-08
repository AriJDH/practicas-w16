package com.youtuber.blog.repository;

import com.youtuber.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepository implements IBlogRepository{

    List<Blog> listBlog = new ArrayList<>();


    @Override
    public Boolean createBlog(Blog blog) {
        return listBlog.add(blog);
    }

    @Override
    public Optional<Blog> getBlogById(Integer id) {
        if(listBlog.size()>0) {
            return listBlog.stream().filter(blog -> blog.getIdBlog().intValue() == id).findFirst();
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<Blog> listBlog() {
        return listBlog;
    }
}
