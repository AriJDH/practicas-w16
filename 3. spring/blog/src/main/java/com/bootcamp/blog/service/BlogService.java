package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.exception.NoBlogFound;
import com.bootcamp.blog.exception.NoBlogsFound;
import com.bootcamp.blog.model.EntradaBlog;
import com.bootcamp.blog.repositories.IBlogRepository;
import com.bootcamp.blog.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

  @Autowired
  IBlogRepository blogRepository;

  @Override
  public ResponseEntity<List<EntradaBlogDTO>> getAllSports() {
    List<EntradaBlogDTO> entradaBlogDTOS = blogRepository.getAllEntradasBlog().stream()
        .map(Mapper::DTOfromEntradaBlog).collect(Collectors.toList());
    if(entradaBlogDTOS.isEmpty()){
      throw new NoBlogsFound();
    }
    return new ResponseEntity<>(entradaBlogDTOS, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<EntradaBlogDTO> getBlog(Integer id) {
    EntradaBlog entradaBlog = blogRepository.getBlog(id);
    if(entradaBlog == null){
      throw new NoBlogFound(id);
    }
    return new ResponseEntity<>(Mapper.DTOfromEntradaBlog(entradaBlog), HttpStatus.OK);
  }
}
