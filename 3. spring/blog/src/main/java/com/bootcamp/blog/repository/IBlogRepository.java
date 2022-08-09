package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogPost;

import java.util.List;

public interface IBlogRepository {

    boolean newBlogRepo(BlogPost blogPost);
    List<BlogPost> allBlogsRepo();

}
