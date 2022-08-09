package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {

    List<BlogPost> blogList = new ArrayList<>();

    @Override
    public boolean newBlogRepo(BlogPost blogPost) { return blogList.add(blogPost); }

    @Override
    public List<BlogPost> allBlogsRepo() { return blogList; }

}