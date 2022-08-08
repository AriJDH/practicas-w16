package com.blog.blog.repository;

import com.blog.blog.exception.BlogAlreadyExistsException;
import com.blog.blog.exception.BlogNotFoundException;
import com.blog.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository {

    static List<EntradaBlog> blogList = new ArrayList<>();

    public Integer createBlog(EntradaBlog entradaBlog){
        EntradaBlog blogVerified = blogList.stream().filter(blog -> blog.getIdBlog() == entradaBlog.getIdBlog()).findFirst().orElse(null);
        if(blogVerified != null){
            throw new BlogAlreadyExistsException(blogVerified.getIdBlog());
        }
        blogList.add(entradaBlog);
        EntradaBlog blogObject = blogList.stream().filter(blog -> blog.getIdBlog() == entradaBlog.getIdBlog()).findFirst().orElse(null);
        return blogObject.getIdBlog();
    }

    public EntradaBlog getBlogById(Integer id){
        EntradaBlog blogFound = blogList.stream().filter(blog -> blog.getIdBlog().equals(id)).findFirst().orElse(null);
        if(blogFound == null){
            throw new BlogNotFoundException(id);
        }
        return blogFound;
    }

    public List<EntradaBlog> getAllBlogs(){
        return blogList;
    }
}
