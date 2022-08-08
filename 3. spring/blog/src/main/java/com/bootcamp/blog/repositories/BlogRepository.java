package com.bootcamp.blog.repositories;

import com.bootcamp.blog.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements  IBlogRepository{

  List<EntradaBlog> entradasBlog = new ArrayList<>();

  @PostConstruct
  public void loadData(){
    entradasBlog.add(new EntradaBlog(0, "Blog de bienvenida", "Kevin Molano", "2022-08-07"));
    entradasBlog.add(new EntradaBlog(1, "Mi segundo blog", "Laura Piedrahita", "2022-08-07"));
  }

  public List<EntradaBlog> getAllEntradasBlog(){
    return entradasBlog;
  }

  @Override
  public EntradaBlog getBlog(Integer id) {
    return entradasBlog.stream()
        .filter(entrada -> entrada.getId().equals(id))
        .findFirst().orElse(null);
  }
}
