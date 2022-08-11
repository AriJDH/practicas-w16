package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepository implements IRepository<EntradaBlog, Long> {
    private List<EntradaBlog> entradaBlogs;

    public EntradaBlogRepository() {
        this.entradaBlogs = new ArrayList<>();
    }

    public EntradaBlog save(EntradaBlog entradaBlog){
        this.entradaBlogs.add(entradaBlog);
        return entradaBlog;
    }

    public List<EntradaBlog> findAll(){
        return this.entradaBlogs;
    }

    public Optional<EntradaBlog> findById(Long id){
        return this.entradaBlogs.stream()
                .filter(entradaBlog -> entradaBlog.getId().equals(id))
                .findFirst();
    }
}
