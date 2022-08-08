package com.blog.blog.repository;

import com.blog.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository {

    static List<EntradaBlog> blogList = new ArrayList<>();

    public Integer createBlog(EntradaBlog entradaBlog){
        blogList.add(entradaBlog);
        System.out.println("Repository BlogList: "+ blogList);

        EntradaBlog blogObject = blogList.stream().filter(blog -> blog.getIdBlog() == entradaBlog.getIdBlog()).findFirst().orElse(null);
        System.out.println("Repository: "+ blogObject);
        return blogObject.getIdBlog();
    }

    public EntradaBlog getBlogById(Integer id){
        EntradaBlog blogFound = blogList.stream().filter(blog -> blog.getIdBlog().equals(id)).findFirst().orElse(null);
        if(blogFound == null){
            return null;
        }
        return blogFound;
    }

    public List<EntradaBlog> getAllBlogs(){
        return blogList;
    }
}
