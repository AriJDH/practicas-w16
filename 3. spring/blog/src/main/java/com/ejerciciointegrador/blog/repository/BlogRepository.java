package com.ejerciciointegrador.blog.repository;

import com.ejerciciointegrador.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository {
    private List<EntradaBlog> entradasBlogList;

    public BlogRepository() {
        this.entradasBlogList = new ArrayList<>();
    }
    @Override
    public void save(EntradaBlog entradaBlog) {
        this.entradasBlogList.add(entradaBlog);
    }
    @Override
    public EntradaBlog find(long id) {
        return this.entradasBlogList.stream().filter(entrada -> entrada.getId()==(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return this.entradasBlogList;
    }
}
