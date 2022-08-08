package com.bootcamp.blog.repositories;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.model.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
  void loadData();
  List<EntradaBlog> getAllEntradasBlog();
  EntradaBlog getBlog(Integer id);
}
