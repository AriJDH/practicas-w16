package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository<EntradaBlog>{

    private List<EntradaBlog> blogs = new ArrayList<>();


    @Override
    public List<EntradaBlog> getAllBlogs() {
        this.blogs.add(new EntradaBlog(1L,"Alimentacion","Maria Palacios",
                LocalDate.of(2021,8,2)));
        this.blogs.add(new EntradaBlog(2L,"Reciclaje","Josue Perez",LocalDate.now()));
        return blogs;
    }

    @Override
    public void createBlog(EntradaBlog entradaBlog) {
        this.blogs.add(entradaBlog);
    }

    @Override
    public EntradaBlog findById(Long id) {

        for(EntradaBlog entradaBlog: blogs){
            if(entradaBlog.getId()==id){
                return entradaBlog;
            }
        }
        return null;
    }
}
