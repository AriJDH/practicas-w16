package com.example.blog.repository;

import com.example.blog.dto.ResponseDTO;
import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogRepository {

    private List<EntradaBlog> entradasBlog;

    public List<EntradaBlog> getEntradasBlog() {
        return entradasBlog;
    }

    public void setEntradasBlog(List<EntradaBlog> entradasBlog) {
        this.entradasBlog = entradasBlog;
    }

    public boolean saveEntradaBlog(EntradaBlog entradaBlog){
       return this.entradasBlog.add(entradaBlog);
    }

    public EntradaBlog getBlogById(Integer id){
       return this.entradasBlog.stream().filter(entradaBlog -> entradaBlog.getId() == id).findFirst().orElse(null);
    }
}
