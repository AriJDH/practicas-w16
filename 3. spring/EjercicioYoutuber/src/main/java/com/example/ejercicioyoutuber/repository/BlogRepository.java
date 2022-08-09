package com.example.ejercicioyoutuber.repository;

import com.example.ejercicioyoutuber.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BlogRepository implements IBlogRepository {
    Map<Integer,EntradaBlog> blogItems = new HashMap<>();

    @Override
    public EntradaBlog getById(int id) {
        return blogItems.get(id);
    }

    @Override
    public void insertBlog(EntradaBlog entradaBlog) {
        blogItems.put(entradaBlog.getBlogID(),entradaBlog);
    }

    @Override
    public boolean isPresent(int id) {
        return blogItems.containsKey(id);
    }

    @Override
    public List<EntradaBlog> getListaEntradas() {
        return blogItems.values().stream().collect(Collectors.toList());
    }


}
